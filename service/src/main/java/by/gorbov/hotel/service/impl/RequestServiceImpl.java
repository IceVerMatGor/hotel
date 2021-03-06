package by.gorbov.hotel.service.impl;

import by.gorbov.hotel.dao.api.RequestDao;
import by.gorbov.hotel.dto.RequestDto;
import by.gorbov.hotel.mapping.api.RequestMapper;
import by.gorbov.hotel.model.Request;
import by.gorbov.hotel.service.api.RequestService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    @Override
    @Transactional
    public void addRequest(Long clientId, RequestDto request) {
        request.setClientId(clientId);
        requestDao.save(requestMapper.toEntity(request));
    }
}
