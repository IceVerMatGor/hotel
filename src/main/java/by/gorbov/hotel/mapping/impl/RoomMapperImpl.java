package by.gorbov.hotel.mapping.impl;

import by.gorbov.hotel.dto.RoomDto;
import by.gorbov.hotel.mapping.api.RoomMapper;
import by.gorbov.hotel.model.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapperImpl extends AbstractMapper<RoomDto, Room> implements RoomMapper {
    @Override
    protected Class<Room> getEntityClass() {
        return Room.class;
    }

    @Override
    protected Class<RoomDto> getDtoClass() {
        return RoomDto.class;
    }
}
