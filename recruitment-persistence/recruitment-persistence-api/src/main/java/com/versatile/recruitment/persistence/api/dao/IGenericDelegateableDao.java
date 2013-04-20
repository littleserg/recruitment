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
public interface IGenericDelegateableDao {

    /**
     * Find all items of concrete entity
     *
     * @param <T>
     *         Entity generic type
     * @param entityClass
     *         Entity data
     * @return List of loaded entities
     */
    <T> List<T> findAll(Class<T> entityClass);

    /**
     * Find concrete item acccording to primary key
     *
     * @param <T>
     *         Entity type
     * @param <PK>
     *         Primary key
     * @param entityClass
     *         Entity class
     * @param id
     *         Primary key
     * @return Loaded entity
     */
    <T, PK extends Serializable> T findById(Class<T> entityClass, PK id);

    /**
     * Find entities by named query and named parameters
     *
     * @param <T>
     *         Entity class type
     * @param entityClass
     *         Entity class
     * @param queryName
     *         Query name
     * @param paramNames
     *         Array of parameter names
     * @param values
     *         Array of parameter values
     * @return List of loaded items
     */
    <T> List<T> findByNamedQueryAndNamedParam(Class<T> entityClass, String queryName,
                                              String[] paramNames, Object[] values);

    /**
     * Find entities by named query and named parameters
     *
     * @param <T>
     *         Entity class type
     * @param entityClass
     *         Entity class
     * @param queryName
     *         Query name
     * @param params
     *         Map of parameters names and it's values
     * @return List of loaded items
     */
    <T> List<T> findByNamedQueryAndNamedParam(Class<T> entityClass, String queryName, Map<String, ?> params);


    <T> List<T> getPage(Class<T> entityClass, int start, int end);

    /**
     * Find entities by query and named parameters
     *
     * @param <T>
     *         Entity class type
     * @param entityClass
     *         Entity class
     * @param query
     *         Sql query
     * @param paramNames
     *         Array of parameter names
     * @param values
     *         Array of parameter values
     * @return List of loaded items
     */
    <T> List<T> findByNamedParam(Class<T> entityClass, String query,
                                 String[] paramNames, Object[] values);

    /**
     * Find entities by query and named parameters
     *
     * @param <T>
     *         Entity class type
     * @param entityClass
     *         Entity class
     * @param query
     *         Sql query
     * @param params
     *         Map of parameters names and it's values
     * @return List of loaded items
     */
    <T> List<T> findByNamedParam(Class<T> entityClass, String query,
                                 Map<String, ?> params);

    /**
     * Store object to database
     *
     * @param data
     *         Data for storing
     * @return Primary kay of persisted entity.
     */
    <T, PK> PK save(final T data);

    /**
     * Store object to database
     *
     * @param data
     *         Data for storing
     */
    <T> void save(final Collection<T> data);

    /**
     * Save or update entity data
     *
     * @param <T>
     *         Entity class type
     * @param entity
     *         Data entity to save
     */
    public <T> void saveOrUpdate(T entity);

    /**
     * Count all entities.
     *
     * @param entityClass
     *         Entity class
     * @return the number of entities
     */
    <T> int countAll(final Class<T> entityClass);

    /**
     * Count entities based on an example.
     *
     * @param entityClass
     *         Entity class.
     * @param exampleInstance
     *         the search criteria
     * @return the number of entities
     */
    <T> int countByExample(final Class<T> entityClass, final T exampleInstance);

    /**
     * delete an entity from the database.
     *
     * @param entity
     *         the entity to delete
     */
    <T> void delete(final T entity);

    /**
     * Delete all entities of class
     *
     * @param <T>
     *         Class type
     * @param entityClass
     *         Entity class
     */
    public <T> void deleteAll(Class<T> entityClass);

    /**
     * Merge entity
     *
     * @param <T>
     *         Entity type
     * @param entity
     *         Entity data to save
     * @return Merged entity
     */
    public <T> T merge(T entity);

    <T> T doInSqlTransaction(final ISqlTransactionCallback<T> callback);
}
