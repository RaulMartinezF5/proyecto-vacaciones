package com.vacaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacaciones.models.Province;

public interface ProvinceRepository extends JpaRepository<Province,Long> {
    
}
