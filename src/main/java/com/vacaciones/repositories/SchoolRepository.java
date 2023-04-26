package com.vacaciones.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacaciones.models.School;

public interface SchoolRepository extends JpaRepository<School,Long>{
    public Optional<School> findByName(String name);
}
