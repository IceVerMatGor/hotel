package by.gorbov.hotel.dao.impl;

import by.gorbov.hotel.dao.api.BillDao;
import by.gorbov.hotel.model.Bill;
import org.springframework.stereotype.Repository;

@Repository
public class BillDaoImpl extends AbstractDao<Bill> implements BillDao {
    @Override
    protected Class<Bill> getEntityClass() {
        return Bill.class;
    }
}
