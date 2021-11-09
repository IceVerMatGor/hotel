package by.gorbov.hotel.dao.impl;

import by.gorbov.hotel.dao.api.ClientDao;
import by.gorbov.hotel.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl extends AbstractDao<Client> implements ClientDao {
    @Override
    protected Class<Client> getEntityClass() {
        return Client.class;
    }
}
