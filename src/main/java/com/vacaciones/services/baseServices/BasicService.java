package com.vacaciones.services.baseServices;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface BasicService<T> {
    
    List<T> findAll();
    T findById();
    void save(T entity);


}
