package com.versatile.recruitment.persistence.impl.dao.itest;

import com.versatile.recruitment.persistence.api.dao.IEventDao;
import com.versatile.recruitment.persistence.api.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Anatolii Trubin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:recruitment-persistence-test.xml")
public class EventDaoITest {
    @Autowired
    private IEventDao eventDao;

    @Test
    public void test_save() {
        Recruiter recruiter = new Recruiter();
        recruiter.setFirstName("test_first_name");
        recruiter.setLastName("test_last_name");
        recruiter.setInternalPhone("test_phone");
        recruiter.setLogin("test_login");
        recruiter.setPassword("test_password");
        recruiter.setEmail("test_email");

        Event event = new Interview();
        Calendar time = Calendar.getInstance();
        Date dateFrom = time.getTime();
        time.add(Calendar.HOUR, -1);
        Date dateTo = time.getTime();
        event.setDateFrom(dateFrom);
        event.setDateTo(dateTo);
        event.setType(EventType.UNDEFINED);
        Set<Person> persons = new HashSet<Person>();
        persons.add(recruiter);
        event.setParticipants(persons);

        eventDao.save(event);
    }

}
