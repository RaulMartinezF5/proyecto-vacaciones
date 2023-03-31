package com.vacaciones.models;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String position;
    @Column(nullable = false)
    private String email;
    @Column(nullable = true)
    private Date singUpDate;
    @Column(nullable = true)
    private Date dateOfWithdrawal;

    public Profile() {
    }

    public Profile(Long id, String firstName, String lastName, String position, String email, Date singUpDate,
            Date dateOfWithdrawal) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.singUpDate = singUpDate;
        this.dateOfWithdrawal = dateOfWithdrawal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getSingUpDate() {
        return singUpDate;
    }

    public void setSingUpDate(Date singUpDate) {
        this.singUpDate = singUpDate;
    }

    public Date getDateOfWithdrawal() {
        return dateOfWithdrawal;
    }

    public void setDateOfWithdrawal(Date dateOfWithdrawal) {
        this.dateOfWithdrawal = dateOfWithdrawal;
    }
}
