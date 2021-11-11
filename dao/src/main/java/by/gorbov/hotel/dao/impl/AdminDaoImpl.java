package by.gorbov.hotel.dao.impl;

import by.gorbov.hotel.dao.api.AdminDao;
import by.gorbov.hotel.model.Admin;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl extends AbstractDao<Admin> implements AdminDao {
    @Override
    protected Class<Admin> getEntityClass() {
        return Admin.class;
    }
}
