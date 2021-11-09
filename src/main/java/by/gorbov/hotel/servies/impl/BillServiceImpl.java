package by.gorbov.hotel.servies.impl;

import by.gorbov.hotel.dao.api.BillDao;
import by.gorbov.hotel.dto.BillDto;
import by.gorbov.hotel.mapping.api.BillMapper;
import by.gorbov.hotel.model.Bill;
import by.gorbov.hotel.servies.api.BillService;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl extends AbstractService<Bill, BillDao, BillDto, BillMapper> implements BillService {

    private final BillDao billDao;

    private final BillMapper billMapper;

    public BillServiceImpl(BillDao billDao, BillMapper billMapper) {
        this.billDao = billDao;
        this.billMapper = billMapper;
    }

    @Override
    protected BillDao getDefaultDao() {
        return billDao;
    }

    @Override
    protected BillMapper getDefaultMapper() {
        return billMapper;
    }
}
