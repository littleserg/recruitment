package com.versatile.recruitment.persistence.impl.dao;

import com.versatile.recruitment.persistence.api.dao.IInterviewerDao;
import com.versatile.recruitment.persistence.api.entity.Interviewer;
import org.springframework.stereotype.Component;

/**
 * @author Anatolii Trubin
 */
@Component
public class InterviewerDao extends SpringHibernateDao<Long, Interviewer> implements IInterviewerDao {
    @Override
    protected Class<Interviewer> getEntityClass() {
        return Interviewer.class;
    }
}
