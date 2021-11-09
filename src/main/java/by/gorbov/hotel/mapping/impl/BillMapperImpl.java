package by.gorbov.hotel.mapping.impl;

import by.gorbov.hotel.dto.BillDto;
import by.gorbov.hotel.mapping.api.BillMapper;
import by.gorbov.hotel.model.Bill;
import org.springframework.stereotype.Component;

@Component
public class BillMapperImpl extends AbstractMapper<BillDto, Bill> implements BillMapper {
    @Override
    protected Class<Bill> getEntityClass() {
        return Bill.class;
    }

    @Override
    protected Class<BillDto> getDtoClass() {
        return BillDto.class;
    }
}
