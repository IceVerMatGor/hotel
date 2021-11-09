package by.gorbov.hotel.dao.impl;

import by.gorbov.hotel.dao.api.RoomDao;
import by.gorbov.hotel.model.Room;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDaoImpl extends AbstractDao<Room> implements RoomDao {
    @Override
    protected Class<Room> getEntityClass() {
        return Room.class;
    }
}
