package com.vacaciones.services;

import java.util.List;

import com.vacaciones.models.User;
import com.vacaciones.services.baseServices.BasicService;

public class UserService implements BasicService<User>{

    @Override
    public List<User> findAll() {
        
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public User findById() {
       
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void save(User entity) {
       
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    
}
