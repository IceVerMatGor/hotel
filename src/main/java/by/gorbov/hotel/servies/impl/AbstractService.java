package by.gorbov.hotel.servies.impl;

import by.gorbov.hotel.dao.api.Dao;
import by.gorbov.hotel.dto.AbstractDto;
import by.gorbov.hotel.mapping.api.Mapper;
import by.gorbov.hotel.model.AbstractEntity;
import by.gorbov.hotel.servies.api.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractService<E extends AbstractEntity, D extends Dao<E>, Dto extends AbstractDto, M extends Mapper<Dto, E>> implements Service<Dto> {

    protected abstract D getDefaultDao();

    protected abstract M getDefaultMapper();

    @Transactional
    @Override
    public void save(Dto dto) {
        getDefaultDao().save(getDefaultMapper().toEntity(dto));
    }

    @Transactional
    @Override
    public void update(Dto newDto) {
        getDefaultDao().update(getDefaultMapper().toEntity(newDto));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }

    @Override
    public Dto getById(Long id) {
        return getDefaultMapper().toDto(getDefaultDao().getById(id));
    }

    @Override
    public List<Dto> getAll() {
        List<Dto> dto = new ArrayList<>();
        getDefaultDao().getAll().forEach(e -> dto.add(getDefaultMapper().toDto(e)));
        return dto;
    }

    @Override
    public List<Dto> getAllSortedBy(String name) {
        return null;
    }
}