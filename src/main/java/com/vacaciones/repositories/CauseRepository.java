package com.vacaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacaciones.models.Cause;

public interface CauseRepository extends JpaRepository<Cause, Long>{
    
}
