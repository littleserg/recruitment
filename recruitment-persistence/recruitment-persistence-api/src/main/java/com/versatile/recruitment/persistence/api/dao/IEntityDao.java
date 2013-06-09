package com.versatile.recruitment.persistence.api.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Sergey Netesanyi
 * @version 1.0
 */
public interface IEntityDao<PK extends Serializable, T> {

    /**
     * Find entity by id.
     *
     * @param id
     *         entity identifier.
     * @return Loaded entity.
     */
    T findById(PK id);

    /**
     * Save new entity to database.
     *
     * @param entity
     *         entity for saving.
     * @return Identifier of the new entity.
     */
    PK save(T entity);

    /**
     * Save or update the entity.
     *
     * @param entity
     *         entity for saving.
     */
    void saveOrUpdate(T entity);

    /**
     * Delete the entity.
     *
     * @param entity
     *         entity for deleting.
     */
    void delete(T entity);

    /**
     * Load all entitys.
     *
     * @return @return List of all entitys.
     */
    List<T> findAll();

    int countAll();

}
