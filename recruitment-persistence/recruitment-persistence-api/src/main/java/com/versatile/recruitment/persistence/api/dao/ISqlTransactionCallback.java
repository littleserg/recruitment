package com.versatile.recruitment.persistence.api.dao;

import org.hibernate.Session;

/**
 * @author Sergey Netesanyi
 * @version 1.0
 */
public interface ISqlTransactionCallback<T> {

    T doInSqlTransaction(Session session);
}
