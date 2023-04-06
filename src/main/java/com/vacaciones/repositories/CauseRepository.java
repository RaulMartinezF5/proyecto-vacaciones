package com.vacaciones.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacaciones.models.Cause;

public interface CauseRepository extends JpaRepository<Cause, Long>{
    
    public Optional<Cause> findByDescription(String description);
}
