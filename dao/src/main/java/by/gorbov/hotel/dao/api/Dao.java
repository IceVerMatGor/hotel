package by.gorbov.hotel.dao.api;


import by.gorbov.hotel.model.AbstractEntity;

import java.util.Comparator;
import java.util.List;

public interface Dao<T extends AbstractEntity> {
    void save(T entity);

    void update(T newEntity);

    void delete(Long id);

    T getById(Long id);

    List<T> getAll();

    List<T> getAllSortedBy(Comparator<T> comparator);
}

