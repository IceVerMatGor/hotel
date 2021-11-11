package by.gorbov.hotel.service.impl;

import by.gorbov.hotel.dao.api.AdminDao;
import by.gorbov.hotel.dto.AdminDto;
import by.gorbov.hotel.mapping.api.AdminMapper;
import by.gorbov.hotel.model.Admin;
import by.gorbov.hotel.service.api.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends AbstractService<Admin, AdminDao, AdminDto, AdminMapper>implements AdminService {

    private final AdminDao adminDao;

    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminDao adminDao, AdminMapper adminMapper) {
        this.adminDao = adminDao;
        this.adminMapper = adminMapper;
    }

    @Override
    protected AdminDao getDefaultDao() {
        return adminDao;
    }

    @Override
    protected AdminMapper getDefaultMapper() {
        return adminMapper;
    }
}
