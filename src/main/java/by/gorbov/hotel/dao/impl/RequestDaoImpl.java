package by.gorbov.hotel.dao.impl;

import by.gorbov.hotel.dao.api.RequestDao;
import by.gorbov.hotel.model.Request;
import org.springframework.stereotype.Repository;

@Repository
public class RequestDaoImpl extends AbstractDao<Request> implements RequestDao {
    @Override
    protected Class<Request> getEntityClass() {
        return Request.class;
    }
}
