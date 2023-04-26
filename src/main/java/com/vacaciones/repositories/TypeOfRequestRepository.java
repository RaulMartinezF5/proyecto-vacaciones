package com.vacaciones.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacaciones.models.TypeOfRequest;

public interface TypeOfRequestRepository extends JpaRepository<TypeOfRequest, Long>{
    
    public Optional<TypeOfRequest> findByName(String name);
}
