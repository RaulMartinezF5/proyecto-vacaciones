package com.vacaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacaciones.models.Request;

public interface RequestRepository extends JpaRepository<Request,Long>{
    
}
