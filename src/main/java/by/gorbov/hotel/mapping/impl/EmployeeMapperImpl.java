package by.gorbov.hotel.mapping.impl;

import by.gorbov.hotel.mapping.api.EmployeeMapper;
import by.gorbov.hotel.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl extends AbstractMapper<by.gorbov.hotel.dto.EmployeeDto, Employee> implements EmployeeMapper {
    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }

    @Override
    protected Class<by.gorbov.hotel.dto.EmployeeDto> getDtoClass() {
        return by.gorbov.hotel.dto.EmployeeDto.class;
    }
}
