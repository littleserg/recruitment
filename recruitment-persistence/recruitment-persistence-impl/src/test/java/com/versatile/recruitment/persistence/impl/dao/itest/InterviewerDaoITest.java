package com.versatile.recruitment.persistence.impl.dao.itest;

import com.versatile.recruitment.persistence.api.dao.IInterviewerDao;
import com.versatile.recruitment.persistence.api.entity.Interviewer;
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
public class InterviewerDaoITest {
    @Autowired
    private IInterviewerDao interviewerDao;

    @Test
    public void test_save(){
        Interviewer interviewer = new Interviewer();
        interviewer.setFirstName("test_first_name");
        interviewer.setLastName("test_last_name");
        interviewer.setInternalPhone("test_phone");
        interviewer.setLogin("test_login");
        interviewer.setPassword("test_password");
        interviewer.setEmail("test_email");

        interviewerDao.save(interviewer);
    }
}
