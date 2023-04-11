package com.vacaciones.controllers;

/* import java.util.Map;

import org.springframework.http.ResponseEntity; */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.models.User;
import com.vacaciones.services.UserService;

@RestController
@RequestMapping(path = "/api")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping(value = "/user/{id}")
    public User detailsUser(@PathVariable String id) {
        return userService.findByDocument(id);
    }
}
