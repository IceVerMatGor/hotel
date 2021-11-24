package by.gorbov.hotel.mapping.impl;

import by.gorbov.hotel.dao.api.ClientDao;
import by.gorbov.hotel.dto.BillDto;
import by.gorbov.hotel.mapping.api.BillMapper;
import by.gorbov.hotel.model.Bill;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class BillMapperImpl extends AbstractMapper<BillDto, Bill> implements BillMapper {

    private final ClientDao clientDao;

    public BillMapperImpl(ClientDao clientDao, ModelMapper mapper) {
        this.clientDao = clientDao;
    }

    @Override
    protected Class<Bill> getEntityClass() {
        return Bill.class;
    }

    @Override
    protected Class<BillDto> getDtoClass() {
        return BillDto.class;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Bill.class, BillDto.class)
                .addMappings(m -> m.skip(BillDto::setClientId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(BillDto.class, Bill.class)
                .addMappings(m -> m.skip(Bill::setClient)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Bill source, BillDto destination) {
        destination.setClientId(getId(source));
    }

    private Long getId(Bill source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getClient().getId();
    }

    @Override
    void mapSpecificFields(BillDto source, Bill destination) {
        destination.setClient(clientDao.getById(source.getClientId()));
    }
}
