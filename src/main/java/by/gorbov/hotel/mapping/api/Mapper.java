package by.gorbov.hotel.mapping.api;

import by.gorbov.hotel.dto.AbstractDto;
import by.gorbov.hotel.model.AbstractEntity;

public interface Mapper<D extends AbstractDto, E extends AbstractEntity> {

    D toDto(E entity);

    E toEntity(D dto);
}
