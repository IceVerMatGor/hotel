package by.gorbov.hotel.mapping.impl;

import by.gorbov.hotel.dao.api.AdminDao;
import by.gorbov.hotel.dto.HotelDto;
import by.gorbov.hotel.dto.RequestDto;
import by.gorbov.hotel.mapping.api.HotelMapper;
import by.gorbov.hotel.model.Hotel;
import by.gorbov.hotel.model.Request;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class HotelMapperImpl extends AbstractMapper<HotelDto, Hotel> implements HotelMapper {


    private final AdminDao adminDao;

    public HotelMapperImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    protected Class<Hotel> getEntityClass() {
        return Hotel.class;
    }

    @Override
    protected Class<HotelDto> getDtoClass() {
        return HotelDto.class;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Hotel.class, HotelDto.class)
                .addMappings(m -> m.skip(HotelDto::setAdminId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(HotelDto.class, Hotel.class)
                .addMappings(m -> m.skip(Hotel::setAdmin)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Hotel source, HotelDto destination) {
        destination.setAdminId(getId(source));
    }

    private Long getId(Hotel source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getAdmin().getId();
    }

    @Override
    void mapSpecificFields(HotelDto source, Hotel destination) {
        destination.setAdmin(adminDao.getById(source.getAdminId()));
    }
}
