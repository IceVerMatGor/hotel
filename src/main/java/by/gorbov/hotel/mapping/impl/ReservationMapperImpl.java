package by.gorbov.hotel.mapping.impl;

import by.gorbov.hotel.dto.ReservationDto;
import by.gorbov.hotel.mapping.api.ReservationMapper;
import by.gorbov.hotel.model.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapperImpl extends AbstractMapper<ReservationDto, Reservation> implements ReservationMapper {
    @Override
    protected Class<Reservation> getEntityClass() {
        return Reservation.class;
    }

    @Override
    protected Class<ReservationDto> getDtoClass() {
        return ReservationDto.class;
    }
}
