package by.gorbov.hotel.servies.api;

import by.gorbov.hotel.dto.ClientDto;

public interface ClientService extends Service<ClientDto> {

    void addRequest(Long clientId, Long requestId);

    void addReservation(Long clientId, Long reservationId);
}
