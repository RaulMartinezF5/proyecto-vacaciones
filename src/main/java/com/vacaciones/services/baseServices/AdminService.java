package com.vacaciones.services.baseServices;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface AdminService<T,P> {

    void delete(P id);
    List<T> findAll();
    T update(P id, T entity);
}
