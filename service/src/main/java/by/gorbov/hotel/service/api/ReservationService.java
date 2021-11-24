package by.gorbov.hotel.service.api;

import by.gorbov.hotel.dto.RequestDto;
import by.gorbov.hotel.dto.ReservationDto;

public interface ReservationService extends Service<ReservationDto> {
    void addReservation(RequestDto request);
}
