package by.gorbov.hotel.mapping.impl;

import by.gorbov.hotel.dao.api.HotelDao;
import by.gorbov.hotel.dto.RoomDto;
import by.gorbov.hotel.mapping.api.RoomMapper;
import by.gorbov.hotel.model.Room;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class RoomMapperImpl extends AbstractMapper<RoomDto, Room> implements RoomMapper {

    private final HotelDao hotelDao;

    public RoomMapperImpl(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }


    @Override
    protected Class<Room> getEntityClass() {
        return Room.class;
    }

    @Override
    protected Class<RoomDto> getDtoClass() {
        return RoomDto.class;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Room.class, RoomDto.class)
                .addMappings(m -> m.skip(RoomDto::setHotelId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(RoomDto.class, Room.class)
                .addMappings(m -> m.skip(Room::setHotel)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Room source, RoomDto destination) {
        destination.setHotelId(getId(source));
    }

    private Long getId(Room source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getHotel().getId();
    }

    @Override
    void mapSpecificFields(RoomDto source, Room destination) {
        if(source.getHotelId()!=null)
        destination.setHotel(hotelDao.getById(source.getHotelId()));
    }
}
