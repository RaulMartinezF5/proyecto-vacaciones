package com.vacaciones.services.adminActionsServices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vacaciones.models.User;
import com.vacaciones.repositories.UserRepository;

@Service
public class ViewAllUserService{
    private UserRepository userRepository;

    public ViewAllUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
 
    public List<User> allList() {
        return userRepository.findAll();
        
    }

}