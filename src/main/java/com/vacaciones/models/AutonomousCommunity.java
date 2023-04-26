package com.vacaciones.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autonomous_communities")
public class AutonomousCommunity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_community")
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToMany
    private List<School> schools;
    
    public AutonomousCommunity() {
    }
    public AutonomousCommunity(Long id, String name, List<School> schools) {
        this.id = id;
        this.name = name;
        this.schools = schools;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<School> getSchools() {
        return schools;
    }
    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    
    
}
