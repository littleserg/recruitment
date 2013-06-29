package com.versatile.recruitment.persistence.impl.dao;

import com.versatile.recruitment.persistence.api.dao.IRecruiterDao;
import com.versatile.recruitment.persistence.api.entity.Recruiter;
import org.springframework.stereotype.Component;

/**
 * @author Anatolii Trubin
 */
@Component
public class RecruiterDao extends SpringHibernateDao<Long, Recruiter> implements IRecruiterDao {
    @Override
    protected Class<Recruiter> getEntityClass() {
        return Recruiter.class;
    }
}
