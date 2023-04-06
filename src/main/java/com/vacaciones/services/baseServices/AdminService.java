package com.vacaciones.services.baseServices;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface AdminService<T> {

    void delete(Long id);
    List<T> findAll();
    T update(Long id, T entity);
}
