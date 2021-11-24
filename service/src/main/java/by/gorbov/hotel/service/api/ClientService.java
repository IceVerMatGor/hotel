package by.gorbov.hotel.service.api;

import by.gorbov.hotel.dto.ClientDto;
import by.gorbov.hotel.dto.RequestDto;

public interface ClientService extends Service<ClientDto> {


    void addReservation(Long clientId, Long reservationId);
}
