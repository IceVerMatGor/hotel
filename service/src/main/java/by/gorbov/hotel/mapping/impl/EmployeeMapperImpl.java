package by.gorbov.hotel.mapping.impl;

import by.gorbov.hotel.dao.api.HotelDao;
import by.gorbov.hotel.dto.EmployeeDto;
import by.gorbov.hotel.mapping.api.EmployeeMapper;
import by.gorbov.hotel.model.Employee;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class EmployeeMapperImpl extends AbstractMapper<by.gorbov.hotel.dto.EmployeeDto, Employee> implements EmployeeMapper {

    private final HotelDao hotelDao;

    public EmployeeMapperImpl(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }

    @Override
    protected Class<by.gorbov.hotel.dto.EmployeeDto> getDtoClass() {
        return by.gorbov.hotel.dto.EmployeeDto.class;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Employee.class, EmployeeDto.class)
                .addMappings(m -> m.skip(EmployeeDto::setHotelId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(EmployeeDto.class, Employee.class)
                .addMappings(m -> m.skip(Employee::setHotel)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Employee source, EmployeeDto destination) {
        destination.setHotelId(getId(source));
    }

    private Long getId(Employee source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getHotel().getId();
    }

    @Override
    void mapSpecificFields(EmployeeDto source, Employee destination) {
        if(source.getHotelId()!=null)
        destination.setHotel(hotelDao.getById(source.getHotelId()));
    }
}
