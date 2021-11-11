package by.gorbov.hotel.service.impl;

import by.gorbov.hotel.dao.api.EmployeeDao;
import by.gorbov.hotel.mapping.api.EmployeeMapper;
import by.gorbov.hotel.model.Employee;
import by.gorbov.hotel.service.api.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends AbstractService<Employee, EmployeeDao, by.gorbov.hotel.dto.EmployeeDto, EmployeeMapper> implements EmployeeService {

    private final EmployeeDao employeeDao;

    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeDao employeeDao, EmployeeMapper employeeMapper) {
        this.employeeDao = employeeDao;
        this.employeeMapper = employeeMapper;
    }

    @Override
    protected EmployeeDao getDefaultDao() {
        return employeeDao;
    }

    @Override
    protected EmployeeMapper getDefaultMapper() {
        return employeeMapper;
    }
}
