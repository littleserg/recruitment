package com.versatile.recruitment.persistence.impl.dao;

import com.versatile.recruitment.persistence.api.dao.IPersonDao;
import com.versatile.recruitment.persistence.api.entity.Person;
import org.springframework.stereotype.Component;

/**
 * @author Anatolii Trubin
 */
@Component
public class PersonDao extends SpringHibernateDao<Long, Person> implements IPersonDao{
    @Override
    protected Class<Person> getEntityClass() {
        return Person.class;
    }
}
