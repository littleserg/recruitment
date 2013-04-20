package com.versatile.recruitment.persistence.impl.dao;

import com.versatile.recruitment.persistence.api.dao.IGenericDelegateableDao;
import com.versatile.recruitment.persistence.api.dao.ISqlTransactionCallback;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class that implements IGenericDao interface for working with
 * database using Hibernate
 *
 * @author Sergey Netesanyi
 * @version 1.0
 */
@Repository
public class HibernateDelegateableDao implements IGenericDelegateableDao {
    /** Spring hibernate template name for working with database, */
    private static final String HIBERNATE_TEMPLATE = "hibernateTemplate";
    /** Logger instance */
    private static final Logger LOG = Logger.getLogger(HibernateDelegateableDao.class);

    /** Hibernate helper for working with database */
    @Autowired
    @Qualifier(HIBERNATE_TEMPLATE)
    private HibernateTemplate hibernateTemplate;

    /** {@inheritDoc} */
    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        List<T> results = hibernateTemplate.loadAll(entityClass);
        Set<T> set = new HashSet<T>(results);
        results = new ArrayList<T>(set);
        return results;

    }

    /** {@inheritDoc} */
    @Override
    public <T, PK extends Serializable> T findById(Class<T> entityClass, PK id) {
        T o = hibernateTemplate.get(entityClass, id);
        if (o == null) {
            LOG.warn("Entity with id '" + id + "' was not found...");
//            throw new ObjectRetrievalFailureException(entityClass, id);
        }
        return o;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> findByNamedQueryAndNamedParam(Class<T> entityClass,
                                                     String queryName, String[] paramNames, Object[] values) {
        return hibernateTemplate
                .findByNamedQueryAndNamedParam(queryName, paramNames, values);
    }

    @Override
    public <T> List<T> findByNamedQueryAndNamedParam(Class<T> entityClass, String queryName,
                                                     Map<String, ?> params) {
        String[] paramNames = new String[params.size()];
        Object[] values = new Object[params.size()];

        List<String> keys = new ArrayList<String>(params.keySet());
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            paramNames[i] = key;
            values[i] = params.get(key);
        }

        return this.findByNamedQueryAndNamedParam(entityClass, queryName, paramNames, values);

    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findByNamedParam(Class<T> entityClass, String query,
                                        String[] paramNames, Object[] values) {

        return hibernateTemplate.findByNamedParam(query, paramNames, values);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findByNamedParam(Class<T> entityClass, String query, Map<String, ?> params)
            throws DataAccessException {
        Query q = hibernateTemplate.getSessionFactory().openSession().getNamedQuery(query);
        if (params != null) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }

        return q.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public <T, PK> PK save(T data) {
        return (PK) hibernateTemplate.save(data);
    }

    @Transactional
    @Override
    public <T> void save(Collection<T> data) {
        hibernateTemplate.saveOrUpdateAll(data);
    }

    @Transactional
    @Override
    public <T> void saveOrUpdate(T entity) {
        hibernateTemplate.saveOrUpdate(entity);
    }

    @Override
    public <T> int countAll(Class<T> entityClass) {

        return this.findAll(entityClass).size();
    }

    @Override
    public <T> int countByExample(Class<T> entityClass, T exampleInstance) {
        Session session = hibernateTemplate.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(entityClass);
        crit.setProjection(Projections.rowCount());
        crit.add(Example.create(exampleInstance));

        return (Integer) crit.list().get(0);

    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getPage(Class<T> entityClass, int start, int end) {
        Session session = hibernateTemplate.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(entityClass);
        criteria.setFirstResult(start);
        criteria.setMaxResults(end);

        return criteria.list();

    }

    @Transactional
    @Override
    public <T> void delete(T entity) {
        hibernateTemplate.delete(entity);
    }

    @Override
    public <T> void deleteAll(Class<T> entityClass) {
        hibernateTemplate.deleteAll(this.findAll(entityClass));
    }

    @Transactional
    @Override
    public <T> T merge(T entity) {
        return hibernateTemplate.merge(entity);
    }

    @Override
    public <T> T doInSqlTransaction(final ISqlTransactionCallback<T> callback) {
        return getHibernateTemplate().execute(new HibernateCallback<T>() {
            @Override
            public T doInHibernate(Session session) throws HibernateException, SQLException {
                Transaction tx = session.beginTransaction();
                T result = callback.doInSqlTransaction(session);
                tx.commit();

                return result;
            }
        });
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

}
