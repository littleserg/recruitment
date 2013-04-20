package com.versatile.recruitment.persistence.api.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * General set of operations for working with database.
 *
 * @author Sergey Netesanyi
 * @version 1.0
 */
public interface IGenericDao<PK extends Serializable, T> {

    /**
     * Find all items of concrete entity
     *
     * @return List of loaded entities
     */
    List<T> findAll();

    /**
     * Find concrete item acccording to primary key
     *
     * @param id
     *         Primary key
     * @return Loaded entity
     */
    T findById(PK id);

    /**
     * Find entities by named query and named parameters
     *
     * @param queryName
     *         Query name
     * @param paramNames
     *         Array of parameter names
     * @param values
     *         Array of parameter values
     * @return List of loaded items
     */
    <T> List<T> findByNamedQueryAndNamedParam(String queryName,
                                              String[] paramNames, Object[] values);

    /**
     * Find entities by named query and named parameters
     *
     * @param queryName
     *         Query name
     * @param params
     *         Map of parameters names and it's values
     * @return List of loaded items
     */
    <T> List<T> findByNamedQueryAndNamedParam(String queryName, Map<String, ?> params);

    List<T> findPage(int start, int end);

    /**
     * Find entities by query and named parameters
     *
     * @param query
     *         Sql query
     * @param paramNames
     *         Array of parameter names
     * @param values
     *         Array of parameter values
     * @return List of loaded items
     */
    <T> List<T> findByNamedParam(String query,
                                 String[] paramNames, Object[] values);

    /**
     * Find entities by query and named parameters
     *
     * @param query
     *         Sql query
     * @param params
     *         Map of parameters names and it's values
     * @return List of loaded items
     */
    <T> List<T> findByNamedParam(String query,
                                 Map<String, ?> params);

    /**
     * Store object to database
     *
     * @param data
     *         Data for storing
     * @return Primary kay of persisted entity.
     */
    PK save(final T data);

    /**
     * Store object to database
     *
     * @param data
     *         Data for storing
     */
    void save(final Collection<T> data);

    /**
     * Save or update entity data
     *
     * @param entity
     *         Data entity to save
     */
    public void saveOrUpdate(T entity);

    /**
     * Count all entities.
     *
     * @return the number of entities
     */
    int countAll();

    /**
     * Count entities based on an example.
     *
     * @param exampleInstance
     *         the search criteria
     * @return the number of entities
     */
    int countByExample(final T exampleInstance);

    /**
     * delete an entity from the database.
     *
     * @param entity
     *         the entity to delete
     */
    void delete(final T entity);

    /** Delete all entities of class */
    public void deleteAll();

    /**
     * Merge entity
     *
     * @param entity
     *         Entity data to save
     * @return Merged entity
     */
    public T merge(T entity);

    T doInSqlTransaction(final ISqlTransactionCallback<T> callback);
}
