package com.versatile.recruitment.persistence.impl.dao.itest;

import com.versatile.recruitment.persistence.api.dao.ICandidateDao;
import com.versatile.recruitment.persistence.api.dao.IRecruiterDao;
import com.versatile.recruitment.persistence.api.entity.Candidate;
import com.versatile.recruitment.persistence.api.entity.Recruiter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Anatolii Trubin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:recruitment-persistence-test.xml")
public class CandidateDaoITest {
    @Autowired
    private ICandidateDao candidateDao;

    @Autowired
    private IRecruiterDao recruiterDao;

    @Test
    public void test_save() {
        Candidate candidate = new Candidate();
        candidate.setFirstName("test_first_name");
        candidate.setLastName("test_last_name");
        candidate.setInternalPhone("test_phone");
        Recruiter recruiter = recruiterDao.findById(1L);
        candidate.setRecruiter(recruiter);
        candidate.setEmail("test_email");

        candidateDao.save(candidate);
    }
}
