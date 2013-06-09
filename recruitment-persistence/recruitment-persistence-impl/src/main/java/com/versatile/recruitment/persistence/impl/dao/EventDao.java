package com.versatile.recruitment.persistence.impl.dao;

import com.versatile.recruitment.persistence.api.dao.IEventDao;
import com.versatile.recruitment.persistence.api.entity.Event;
import org.springframework.stereotype.Component;

/**
 * @author Anatolii Trubin
 */
@Component
public class EventDao extends SpringHibernateDao<Long, Event> implements IEventDao {
    @Override
    protected Class<Event> getEntityClass() {
        return Event.class;
    }
}
