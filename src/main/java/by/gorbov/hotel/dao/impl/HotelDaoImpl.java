package by.gorbov.hotel.dao.impl;

import by.gorbov.hotel.dao.api.HotelDao;
import by.gorbov.hotel.model.Hotel;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDaoImpl extends AbstractDao<Hotel> implements HotelDao {
    @Override
    protected Class<Hotel> getEntityClass() {
        return Hotel.class;
    }
}
