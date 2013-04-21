package com.versatile.recruitment.persistence.impl.entity;

public class Interview extends Event {
    private static final long serialVersionUID = -4198026991895028485L;

    private Recruiter recruiter;
    private Candidate candidate;
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
        if (!(o instanceof Interview)) return false;
        if (!super.equals(o)) return false;

        Interview interview = (Interview) o;

        if (candidate != null ? !candidate.equals(interview.candidate) : interview.candidate != null) return false;
        if (recruiter != null ? !recruiter.equals(interview.recruiter) : interview.recruiter != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (recruiter != null ? recruiter.hashCode() : 0);
        result = 31 * result + (candidate != null ? candidate.hashCode() : 0);
        return result;
    }
}
