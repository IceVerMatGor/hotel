package by.gorbov.hotel.mapping.impl;

import by.gorbov.hotel.dto.HotelDto;
import by.gorbov.hotel.mapping.api.HotelMapper;
import by.gorbov.hotel.model.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelMapperImpl extends AbstractMapper<HotelDto, Hotel> implements HotelMapper {
    @Override
    protected Class<Hotel> getEntityClass() {
        return Hotel.class;
    }

    @Override
    protected Class<HotelDto> getDtoClass() {
        return HotelDto.class;
    }
}
