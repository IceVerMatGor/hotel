package by.gorbov.hotel.service.impl;

import by.gorbov.hotel.dao.api.BillDao;
import by.gorbov.hotel.dao.api.RequestDao;
import by.gorbov.hotel.dao.api.ReservationDao;
import by.gorbov.hotel.dao.api.RoomDao;
import by.gorbov.hotel.dto.RequestDto;
import by.gorbov.hotel.dto.ReservationDto;
import by.gorbov.hotel.mapping.api.RequestMapper;
import by.gorbov.hotel.mapping.api.ReservationMapper;
import by.gorbov.hotel.model.*;
import by.gorbov.hotel.service.api.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;


@Service
public class ReservationServiceImpl extends AbstractService<Reservation, ReservationDao, ReservationDto, ReservationMapper> implements ReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    private final ReservationDao reservationDao;
    private final RoomDao roomDao;
    private final RequestDao requestDao;
    private final BillDao billDao;

    private final ReservationMapper reservationMapper;
    private final RequestMapper requestMapper;

    public ReservationServiceImpl(ReservationDao reservationDao, RoomDao roomDao, RequestDao requestDao, BillDao billDao, ReservationMapper reservationMapper, RequestMapper requestMapper) {
        this.reservationDao = reservationDao;
        this.roomDao = roomDao;
        this.requestDao = requestDao;
        this.billDao = billDao;
        this.reservationMapper = reservationMapper;
        this.requestMapper = requestMapper;
    }

    @Override
    protected ReservationDao getDefaultDao() {
        return reservationDao;
    }

    @Override
    protected ReservationMapper getDefaultMapper() {
        return reservationMapper;
    }

    @Override
    @Transactional
    public void addReservation(RequestDto request) {
        Reservation reservation = new Reservation();
        reservation.setClient(requestMapper.toEntity(request).getClient());
        reservation.setStartDate(request.getStartDate());
        reservation.setEndDate(request.getEndDate());

        Optional<Room> room = findRoom(request);
        if (room.isPresent()) {
            reservation.setRoom(room.get());
            getDefaultDao().save(reservation);
            LOGGER.info("reservation saved per roomId {}", reservation.getRoom().getId());

            request.setStatus("BOOKED");
            requestDao.update(requestMapper.toEntity(request));
            LOGGER.info("request with id {} updated", request.getId());

            Bill bill = new Bill();
            Client client = new Client();
            client.setId(request.getClientId());
            bill.setClient(client);
            bill.setPrice(reservation.getRoom().getPrice());
            billDao.save(bill);
            LOGGER.info("bill {}$ saved per userId {}", bill.getPrice(), client.getId());
        } else {
            request.setStatus(RequestStatus.NO_SUITABLE_ROOM.name());
            requestDao.update(requestMapper.toEntity(request));
        }

    }

    public Optional<Room> findRoom(RequestDto request) {
        try {
            return Optional.ofNullable(roomDao.getAll().stream()
                    .filter(room -> room.getPlace() >= request.getPlace())
                    .filter(room -> Objects.equals(room.getRoomClass().toString(), request.getRoomClass()))
                    .filter(room -> room.getReservations()
                            .stream().allMatch(res -> Math.max(request.getStartDate().getTime(), res.getStartDate().getTime()) >
                                    Math.min(request.getEndDate().getTime(), res.getEndDate().getTime())))
                    .findFirst().orElseThrow(() -> new NullPointerException("no suitable room for this request " + request.getClass().getSimpleName())));
        } catch (NullPointerException e) {
            LOGGER.error("room is not found", e);
            return Optional.empty();
        }
    }
}
