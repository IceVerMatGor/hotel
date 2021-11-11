package by.gorbov.hotel.mapping.impl;

import by.gorbov.hotel.dto.AbstractDto;
import by.gorbov.hotel.mapping.api.Mapper;
import by.gorbov.hotel.model.AbstractEntity;
import org.modelmapper.ModelMapper;

import java.util.Objects;

public abstract class AbstractMapper<D extends AbstractDto, E extends AbstractEntity> implements Mapper<D, E> {

    private final ModelMapper mapper = new ModelMapper();

    protected abstract Class<E> getEntityClass();

    protected abstract Class<D> getDtoClass();

    @Override
    public D toDto(E entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, getDtoClass());
    }

    @Override
    public E toEntity(D dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, getEntityClass());
    }
}
