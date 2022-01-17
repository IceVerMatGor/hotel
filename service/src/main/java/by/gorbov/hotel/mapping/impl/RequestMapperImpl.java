package by.gorbov.hotel.mapping.impl;

import by.gorbov.hotel.dao.api.ClientDao;
import by.gorbov.hotel.dto.RequestDto;
import by.gorbov.hotel.mapping.api.RequestMapper;
import by.gorbov.hotel.model.Request;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class RequestMapperImpl extends AbstractMapper<RequestDto, Request> implements RequestMapper {

    private final ClientDao clientDao;

    public RequestMapperImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    protected Class<Request> getEntityClass() {
        return Request.class;
    }

    @Override
    protected Class<RequestDto> getDtoClass() {
        return RequestDto.class;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Request.class, RequestDto.class)
                .addMappings(m -> m.skip(RequestDto::setClientId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(RequestDto.class, Request.class)
                .addMappings(m -> m.skip(Request::setClient)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Request source, RequestDto destination) {
        destination.setClientId(getId(source));
    }

    private Long getId(Request source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getClient().getId();
    }

    @Override
    void mapSpecificFields(RequestDto source, Request destination) {
        if(source.getClientId()!=null)
        destination.setClient(clientDao.getById(source.getClientId()));
    }
}
