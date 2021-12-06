package by.gorbov.hotel.service.impl;

import by.gorbov.hotel.dao.api.Dao;
import by.gorbov.hotel.dto.AbstractDto;
import by.gorbov.hotel.mapping.api.Mapper;
import by.gorbov.hotel.model.AbstractEntity;
import by.gorbov.hotel.service.api.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractService<E extends AbstractEntity, D extends Dao<E>, Dto extends AbstractDto, M extends Mapper<Dto, E>> implements Service<Dto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);

    protected abstract D getDefaultDao();

    protected abstract M getDefaultMapper();

    @Transactional
    @Override
    public void save(Dto dto) {
        getDefaultDao().save(getDefaultMapper().toEntity(dto));
        LOGGER.info("{} saved",dto.getClass());
    }

    @Transactional
    @Override
    public void update(Dto newDto) {
        getDefaultDao().update(getDefaultMapper().toEntity(newDto));
        LOGGER.info("{} updated",newDto.getClass().getSimpleName());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        getDefaultDao().delete(id);
        LOGGER.info("entity with id {} deleted",id);
    }

    @Override
    public Dto getById(Long id) {
        LOGGER.info("get request for entity with id {}",id);
        return getDefaultMapper().toDto(getDefaultDao().getById(id));
    }

    @Override
    public List<Dto> getAll() {
        List<Dto> dto = new ArrayList<>();
        getDefaultDao().getAll().forEach(e -> dto.add(getDefaultMapper().toDto(e)));
        LOGGER.info("getAll request");
        return dto;
    }

    @Override
    public List<Dto> getAllSortedBy(String name) {
        List<E> entities = new ArrayList<>();
        switch (name){
            case "id":{
                entities = getDefaultDao().getAllSortedBy(Comparator.comparing(AbstractEntity::getId));
            }
            break;
        }
        List<Dto> dto = new ArrayList<>();
        entities.forEach(e -> dto.add(getDefaultMapper().toDto(e)));
        return dto;
    }
}
