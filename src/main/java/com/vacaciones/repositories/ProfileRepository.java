package com.vacaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacaciones.models.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    
}
