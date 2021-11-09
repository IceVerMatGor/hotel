package by.gorbov.hotel.servies.impl;

import by.gorbov.hotel.dao.api.RoomDao;
import by.gorbov.hotel.dto.RoomDto;
import by.gorbov.hotel.mapping.api.RoomMapper;
import by.gorbov.hotel.model.Room;
import by.gorbov.hotel.servies.api.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl extends AbstractService<Room, RoomDao, RoomDto, RoomMapper> implements RoomService {

    private final RoomDao roomDao;

    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomDao roomDao, RoomMapper roomMapper) {
        this.roomDao = roomDao;
        this.roomMapper = roomMapper;
    }

    @Override
    protected RoomDao getDefaultDao() {
        return roomDao;
    }

    @Override
    protected RoomMapper getDefaultMapper() {
        return roomMapper;
    }
}
