package com.vacaciones.services.baseServices;

import org.springframework.stereotype.Service;

@Service
public interface AdminService<T> {

    void delete(Long id);

    T update(Long id, T entity);
}
