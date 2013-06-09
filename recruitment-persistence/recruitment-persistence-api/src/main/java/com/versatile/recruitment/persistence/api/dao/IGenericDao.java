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
public interface IGenericDao<PK extends Serializable, T> extends IEntityDao<PK, T> {


    /**
     * Find entities by named query and named parameters
     *
     * @param queryName  Query name
     * @param paramNames Array of parameter names
     * @param values     Array of parameter values
     * @return List of loaded items
     */
    <T> List<T> findByNamedQueryAndNamedParam(String queryName,
                                              String[] paramNames, Object[] values);

    /**
     * Find entities by named query and named parameters
     *
     * @param queryName Query name
     * @param params    Map of parameters names and it's values
     * @return List of loaded items
     */
    <T> List<T> findByNamedQueryAndNamedParam(String queryName, Map<String, ?> params);

    List<T> findPage(int start, int end);

    /**
     * Find entities by query and named parameters
     *
     * @param query      Sql query
     * @param paramNames Array of parameter names
     * @param values     Array of parameter values
     * @return List of loaded items
     */
    <T> List<T> findByNamedParam(String query,
                                 String[] paramNames, Object[] values);

    /**
     * Find entities by query and named parameters
     *
     * @param query  Sql query
     * @param params Map of parameters names and it's values
     * @return List of loaded items
     */
    <T> List<T> findByNamedParam(String query,
                                 Map<String, ?> params);

    /**
     * Store object to database
     *
     * @param data Data for storing
     */
    void save(final Collection<T> data);


    /**
     * Count entities based on an example.
     *
     * @param exampleInstance the search criteria
     * @return the number of entities
     */
    int countByExample(final T exampleInstance);


    /**
     * Delete all entities of class
     */
    public void deleteAll();

    /**
     * Merge entity
     *
     * @param entity Entity data to save
     * @return Merged entity
     */
    public T merge(T entity);

    T doInSqlTransaction(final ISqlTransactionCallback<T> callback);
}
