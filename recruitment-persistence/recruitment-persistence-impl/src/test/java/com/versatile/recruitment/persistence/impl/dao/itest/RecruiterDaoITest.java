package com.versatile.recruitment.persistence.impl.dao.itest;

import com.versatile.recruitment.persistence.api.dao.IRecruiterDao;
import com.versatile.recruitment.persistence.api.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * @author Anatolii Trubin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:recruitment-persistence-test.xml")
public class RecruiterDaoITest {
    @Autowired
    private IRecruiterDao recruterDao;

    @Test
    public void test_save() {
        Recruiter recruiter = new Recruiter();
        recruiter.setFirstName("test_first_name");
        recruiter.setLastName("test_last_name");
        recruiter.setInternalPhone("test_phone");
        recruiter.setLogin("test_login");
        recruiter.setPassword("test_password");
        recruiter.setEmail("test_email");
        recruiter.setStatus(UserStatus.ACTIVE);

        Event event = new Interview();
        Calendar time = Calendar.getInstance();
        Date dateFrom = time.getTime();
        time.add(Calendar.HOUR, -1);
        Date dateTo = time.getTime();
        event.setDateFrom(dateFrom);
        event.setDateTo(dateTo);
        event.setType(EventType.UNDEFINED);

        Set<Event> events = new HashSet<Event>();
        events.add(event);
        recruiter.setEvents(events);
        recruterDao.save(recruiter);
    }
}
