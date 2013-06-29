package com.versatile.recruitment.persistence.impl.dao.itest;

import com.versatile.recruitment.persistence.api.dao.IInterviewDao;
import com.versatile.recruitment.persistence.api.entity.EventType;
import com.versatile.recruitment.persistence.api.entity.Interview;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Anatolii Trubin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:recruitment-persistence-test.xml")
public class InterviewDaoITest {
    @Autowired
    private IInterviewDao interviewDao;

    @Test
    public void test_save(){
        Interview interview = new Interview();
        Calendar time = Calendar.getInstance();
        Date dateFrom = time.getTime();
        time.add(Calendar.HOUR, -1);
        Date dateTo = time.getTime();
        interview.setDateFrom(dateFrom);
        interview.setDateTo(dateTo);
        interview.setType(EventType.UNDEFINED);


        interviewDao.save(interview);
    }
}
