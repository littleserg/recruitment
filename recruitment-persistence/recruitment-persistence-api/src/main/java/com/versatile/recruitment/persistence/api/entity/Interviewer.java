package com.versatile.recruitment.persistence.api.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Interviewer extends User{
    private static final long serialVersionUID = 4765607586658617653L;
}
