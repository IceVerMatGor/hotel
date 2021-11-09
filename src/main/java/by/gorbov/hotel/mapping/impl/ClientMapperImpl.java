package by.gorbov.hotel.mapping.impl;

import by.gorbov.hotel.dto.ClientDto;
import by.gorbov.hotel.mapping.api.ClientMapper;
import by.gorbov.hotel.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapperImpl extends AbstractMapper<ClientDto, Client> implements ClientMapper {
    @Override
    protected Class<Client> getEntityClass() {
        return Client.class;
    }

    @Override
    protected Class<ClientDto> getDtoClass() {
        return ClientDto.class;
    }
}
