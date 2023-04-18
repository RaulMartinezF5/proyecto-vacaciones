package com.vacaciones.models;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String document;

    @Column(nullable = false)
    private String password;

    private String contractedUser;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_users", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "chief-has-employes", joinColumns = @JoinColumn(name = "chief_id"), inverseJoinColumns = @JoinColumn(name = "employe_id"))
    private Set<User> employes;

    @OneToOne
    private Profile profile;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "requests_users", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "request_id"))
    private List<Request> requests;

    public User() {
    }

    public User(String document, String password, Set<Role> roles) {
        this.document = document;
        this.password = password;
        this.roles = roles;
        this.contractedUser = "active";
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<User> getEmployes() {
        return employes;
    }

    public void setEmployes(Set<User> employes) {
        this.employes = employes;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public String getContractedUser() {
        return contractedUser;
    }

    public void setContractedUser(String contractedUser) {
        this.contractedUser = contractedUser;
    }

}
