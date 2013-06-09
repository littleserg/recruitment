package com.versatile.recruitment.persistence.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Event implements Serializable {
    private static final long serialVersionUID = 7827414366436899404L;

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private char type;
    @Column
    private Date dateFrom;
    @Column
    private Date dateTo;
    @ManyToMany (cascade=CascadeType.ALL)
    @JoinTable(name = "person_event",
            joinColumns = @JoinColumn(name = "eventId"),
            inverseJoinColumns = @JoinColumn(name = "personId"))
    private Set<Person> participants;

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventType getType() {
        return EventType.fromValue(type);
    }

    public void setType(EventType type) {
        this.type = type.toValue();
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Set<Person> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Person> participants) {
        this.participants = participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (!dateFrom.equals(event.dateFrom)) return false;
        if (!dateTo.equals(event.dateTo)) return false;
        if (type != event.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type;
        result = 31 * result + dateFrom.hashCode();
        result = 31 * result + dateTo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Event");
        sb.append("{id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", dateFrom=").append(dateFrom);
        sb.append(", dateTo=").append(dateTo);
        sb.append('}');
        return sb.toString();
    }
}
