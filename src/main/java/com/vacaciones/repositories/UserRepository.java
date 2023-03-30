package com.vacaciones.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacaciones.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    public Optional<User> findByIdentityDocument(String identityDocument);
}
