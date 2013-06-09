package com.versatile.recruitment.persistence.impl.dao;

import com.versatile.recruitment.persistence.api.dao.ICandidateDao;
import com.versatile.recruitment.persistence.api.entity.Candidate;
import org.springframework.stereotype.Component;

/**
 * @author Anatolii Trubin
 */
@Component
public class CandidateDao extends SpringHibernateDao<Long, Candidate> implements ICandidateDao {
    @Override
    protected Class<Candidate> getEntityClass() {
        return Candidate.class;
    }
}
