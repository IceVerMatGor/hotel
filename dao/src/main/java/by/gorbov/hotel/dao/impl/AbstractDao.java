package by.gorbov.hotel.dao.impl;

import by.gorbov.hotel.dao.api.Dao;
import by.gorbov.hotel.model.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractDao<T extends AbstractEntity> implements Dao<T> {
    @PersistenceContext
    private EntityManager entityManager;

    protected abstract Class<T> getEntityClass();

    @Override
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T newEntity) {
        entityManager.merge(newEntity);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(getEntityClass(), id));
    }

    @Override
    public T getById(Long id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getEntityClass());
        Root<T> from = query.from(getEntityClass());
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<T> getAllSortedBy(Comparator<T> comparator) {
        List<T> toSort = getAll();
        toSort.sort(comparator);
        return toSort;
    }
}
