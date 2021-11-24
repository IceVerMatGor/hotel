package by.gorbov.hotel.mapping.impl;

import by.gorbov.hotel.dao.api.ClientDao;
import by.gorbov.hotel.dao.api.RoomDao;
import by.gorbov.hotel.dto.ReservationDto;
import by.gorbov.hotel.mapping.api.ReservationMapper;
import by.gorbov.hotel.model.Reservation;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class ReservationMapperImpl extends AbstractMapper<ReservationDto, Reservation> implements ReservationMapper {

    private final ClientDao clientDao;
    private final RoomDao roomDao;

    public ReservationMapperImpl(ClientDao clientDao, RoomDao roomDao) {
        this.clientDao = clientDao;
        this.roomDao = roomDao;
    }


    @Override
    protected Class<Reservation> getEntityClass() {
        return Reservation.class;
    }

    @Override
    protected Class<ReservationDto> getDtoClass() {
        return ReservationDto.class;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Reservation.class, ReservationDto.class)
                .addMappings(m -> m.skip(ReservationDto::setClientId)).setPostConverter(toDtoConverter())
                .addMappings(m -> m.skip(ReservationDto::setRoomId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(ReservationDto.class, Reservation.class)
                .addMappings(m -> m.skip(Reservation::setClient)).setPostConverter(toEntityConverter())
                .addMappings(m -> m.skip(Reservation::setRoom)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Reservation source, ReservationDto destination) {
        destination.setClientId(getClientId(source));
        destination.setRoomId(getRoomId(source));
    }

    private Long getClientId(Reservation source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getClient().getId();
    }

    private Long getRoomId(Reservation source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getRoom().getId();
    }

    @Override
    void mapSpecificFields(ReservationDto source, Reservation destination) {
        destination.setClient(clientDao.getById(source.getClientId()));
        destination.setRoom(roomDao.getById(source.getRoomId()));
    }
}
