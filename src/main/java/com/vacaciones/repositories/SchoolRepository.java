package com.vacaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacaciones.models.School;

public interface SchoolRepository extends JpaRepository<School,Long>{
    
}
