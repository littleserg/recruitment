package com.versatile.recruitment.persistence.api.entity;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Interview extends Event {
    private static final long serialVersionUID = -4198026991895028485L;

    @ManyToOne
    @JoinColumn(name = "recruiterId")
    private Recruiter recruiter;
    @ManyToOne
    @JoinColumn(name = "candidateId")
    private Candidate candidate;
    @Column
    private String comment;

    public Interview() {
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!super.equals(o)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return result;
    }
}
