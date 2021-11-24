package by.gorbov.hotel.service.api;

import by.gorbov.hotel.dto.RequestDto;

public interface RequestService extends Service<RequestDto> {
    void addRequest(Long clientId, RequestDto request);
}
