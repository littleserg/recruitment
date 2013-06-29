package com.versatile.recruitment.persistence.api.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Recruiter extends User {

    private static final long serialVersionUID = -2362070404564607574L;

    public Recruiter() {
    }
}
