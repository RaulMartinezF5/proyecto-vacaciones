package com.vacaciones.controllers.adminActionControllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.models.School;
import com.vacaciones.services.adminActionsServices.FindUserOfSchoolService;

@RestController
@RequestMapping(path = "/api/admin")
public class SchoolOfUserController {
    
    private FindUserOfSchoolService service;

    public SchoolOfUserController(FindUserOfSchoolService service) {
        this.service = service;
    }

    @GetMapping(value="/user/{document}/School")
    public ResponseEntity<Map<String,String>> schoolOfUser(@PathVariable String document) {
        try {
            
            School schoolOfUser = service.schoolOfUser(document);

            Map<String, String> json = new HashMap<>();

            json.put("school", schoolOfUser.getName());
            
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("error", e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json); 
        }
    }
}
