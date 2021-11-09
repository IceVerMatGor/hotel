package by.gorbov.hotel.mapping.impl;

import by.gorbov.hotel.dto.AdminDto;
import by.gorbov.hotel.mapping.api.AdminMapper;
import by.gorbov.hotel.model.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapperImpl extends AbstractMapper<AdminDto, Admin> implements AdminMapper {

    @Override
    protected Class<Admin> getEntityClass() {
        return Admin.class;
    }

    @Override
    protected Class<AdminDto> getDtoClass() {
        return AdminDto.class;
    }
}
