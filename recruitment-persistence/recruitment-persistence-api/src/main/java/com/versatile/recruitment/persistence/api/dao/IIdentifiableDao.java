package com.versatile.recruitment.persistence.api.dao;

import com.versatile.recruitment.persistence.api.entity.Identifiable;

/** Presents default DAO operations for {@link Identifiable} objects. */
public interface IIdentifiableDao<T extends Identifiable> {

    /**
     * Gets entity with provided identifier.
     *
     * @param id
     *         the id to set.
     * @return the found entity.
     */
    T findById(Long id);

    /**
     * Deletes entity with provided identifier.
     *
     * @param id
     *         the id to set.
     */
    void delete(Long id);

}