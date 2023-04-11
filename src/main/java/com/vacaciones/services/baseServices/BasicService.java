package com.vacaciones.services.baseServices;


import org.springframework.stereotype.Service;

@Service
public interface BasicService<T> {

    T findById(Long id);

    void save(T entity);

}
