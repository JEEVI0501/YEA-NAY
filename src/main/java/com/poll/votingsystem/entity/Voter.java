package com.poll.votingsystem.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="voters")
@Entity
public class Voter {
    @Id
    @Column(name="id")
    private Long id;
    public Voter() {
    super();
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name="first_name")
    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    @Column(name="last_name")
    private String lastname;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name="rollno")
    private String rollno;

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public Voter(Long id, String firstname, String lastname, String rollno, Boolean hasVoted) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.rollno = rollno;
        this.hasVoted = hasVoted;
    }

    @Column(name="hasvoted")
    private Boolean hasVoted;

    public Boolean getHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(Boolean hasVoted) {
        this.hasVoted = hasVoted;
    }


}



