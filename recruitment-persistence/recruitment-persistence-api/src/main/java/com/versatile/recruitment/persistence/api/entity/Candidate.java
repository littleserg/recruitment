package com.versatile.recruitment.persistence.api.entity;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Candidate extends Person{
    private static final long serialVersionUID = -5035123623987030367L;
    @ManyToOne
    @JoinColumn(name = "recruiterId")
    private Recruiter recruiter;
    @Column
    private CandidateStatus status;

    public Candidate() {
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public CandidateStatus getStatus() {
        return status;
    }

    public void setStatus(CandidateStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Candidate");
        sb.append("{recruiter=").append(recruiter);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
