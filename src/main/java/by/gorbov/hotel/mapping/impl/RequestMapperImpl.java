package by.gorbov.hotel.mapping.impl;

import by.gorbov.hotel.dto.RequestDto;
import by.gorbov.hotel.mapping.api.RequestMapper;
import by.gorbov.hotel.model.Request;
import org.springframework.stereotype.Component;

@Component
public class RequestMapperImpl extends AbstractMapper<RequestDto, Request> implements RequestMapper {
    @Override
    protected Class<Request> getEntityClass() {
        return Request.class;
    }

    @Override
    protected Class<RequestDto> getDtoClass() {
        return RequestDto.class;
    }
}
