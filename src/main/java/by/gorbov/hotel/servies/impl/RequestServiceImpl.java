package by.gorbov.hotel.servies.impl;

import by.gorbov.hotel.dao.api.RequestDao;
import by.gorbov.hotel.dto.RequestDto;
import by.gorbov.hotel.mapping.api.RequestMapper;
import by.gorbov.hotel.model.Request;
import by.gorbov.hotel.servies.api.RequestService;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl extends AbstractService<Request, RequestDao, RequestDto, RequestMapper> implements RequestService {

    private final RequestDao requestDao;

    private final RequestMapper requestMapper;

    public RequestServiceImpl(RequestDao requestDao, RequestMapper requestMapper) {
        this.requestDao = requestDao;
        this.requestMapper = requestMapper;
    }

    @Override
    protected RequestDao getDefaultDao() {
        return requestDao;
    }

    @Override
    protected RequestMapper getDefaultMapper() {
        return requestMapper;
    }

}
