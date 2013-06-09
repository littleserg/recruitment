package com.versatile.recruitment.persistence.impl.dao;

import com.versatile.recruitment.persistence.api.dao.IInterviewDao;
import com.versatile.recruitment.persistence.api.entity.Interview;
import org.springframework.stereotype.Component;

/**
 * @author Anatolii Trubin
 */
@Component
public class InterviewDao extends SpringHibernateDao<Long, Interview> implements IInterviewDao{
    @Override
    protected Class<Interview> getEntityClass() {
        return Interview.class;
    }
}
