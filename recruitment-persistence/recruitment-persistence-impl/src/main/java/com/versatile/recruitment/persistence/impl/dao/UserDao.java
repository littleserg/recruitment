package com.versatile.recruitment.persistence.impl.dao;

import com.versatile.recruitment.persistence.api.dao.IUserDao;
import com.versatile.recruitment.persistence.api.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author Anatolii Trubin
 */
@Component
public class UserDao extends SpringHibernateDao<Long, User> implements IUserDao{

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
