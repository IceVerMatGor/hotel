package by.gorbov.hotel.service.impl;

import by.gorbov.hotel.dao.api.HotelDao;
import by.gorbov.hotel.dto.HotelDto;
import by.gorbov.hotel.mapping.api.HotelMapper;
import by.gorbov.hotel.model.Hotel;
import by.gorbov.hotel.model.Room;
import by.gorbov.hotel.service.api.HotelService;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl extends AbstractService<Hotel, HotelDao, HotelDto, HotelMapper> implements HotelService {

    private final HotelDao hotelDao;

    private final HotelMapper hotelMapper;

    public HotelServiceImpl(HotelDao hotelDao, HotelMapper hotelMapper) {
        this.hotelDao = hotelDao;
        this.hotelMapper = hotelMapper;
    }

    @Override
    protected HotelDao getDefaultDao() {
        return hotelDao;
    }

    @Override
    protected HotelMapper getDefaultMapper() {
        return hotelMapper;
    }

}
