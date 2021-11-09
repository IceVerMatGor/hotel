package by.gorbov.hotel.dao.impl;

import by.gorbov.hotel.dao.api.EmployeeDao;
import by.gorbov.hotel.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee> implements EmployeeDao {

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
