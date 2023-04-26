package com.vacaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacaciones.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
