package com.vacaciones.services;

import org.springframework.stereotype.Service;

import com.vacaciones.models.Role;
import com.vacaciones.repositories.RoleRepository;
import com.vacaciones.services.baseServices.BasicService;

@Service
public class RoleService implements BasicService<Role> {

    private RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void save(Role role) {
        repository.save(role);
    }

}
