package by.gorbov.hotel.servies.impl;

import by.gorbov.hotel.dao.api.ReservationDao;
import by.gorbov.hotel.dto.ReservationDto;
import by.gorbov.hotel.mapping.api.ReservationMapper;
import by.gorbov.hotel.model.Reservation;
import by.gorbov.hotel.servies.api.ReservationService;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl extends AbstractService<Reservation, ReservationDao, ReservationDto, ReservationMapper> implements ReservationService {

    private final ReservationDao reservationDao;

    private final ReservationMapper reservationMapper;

    public ReservationServiceImpl(ReservationDao reservationDao, ReservationMapper reservationMapper) {
        this.reservationDao = reservationDao;
        this.reservationMapper = reservationMapper;
    }

    @Override
    protected ReservationDao getDefaultDao() {
        return reservationDao;
    }

    @Override
    protected ReservationMapper getDefaultMapper() {
        return reservationMapper;
    }
}
