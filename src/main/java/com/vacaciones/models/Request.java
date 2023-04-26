package com.vacaciones.models;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_request")
    private Long id;
    @Column(nullable = false)
    private String issue;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
    @Column Integer quantityOfDays;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cause_request", joinColumns = @JoinColumn(name = "request_id"), inverseJoinColumns = @JoinColumn(name = "cause_id"))
    private Set<Cause> causes;

    @ManyToMany(mappedBy = "requests")
    private Set<User> users;

    public Request() {
    }

    public Request(Long id, String issue, String state, Date startDate, Date endDate, Integer quantityOfDays) {
        this.id = id;
        this.issue = issue;
        this.state = state;
        this.startDate = startDate;
        this.endDate = endDate;
        this.quantityOfDays = quantityOfDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Cause> getCauses() {
        return causes;
    }

    public void setCauses(Set<Cause> causes) {
        this.causes = causes;
    }

    public Integer getQuantityOfDays() {
        return quantityOfDays;
    }

    public void setQuantityOfDays(Integer quantityOfDays) {
        this.quantityOfDays = quantityOfDays;
    }
    

}
