package com.vacaciones.controllers.adminActionControllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.payLoads.CreateUserPayload;
import com.vacaciones.services.adminActionsServices.ProfileModificationsService;

@RestController
@RequestMapping(path = "/api/admin")
public class ProfileModificationsController {
    
    
    private ProfileModificationsService service;

    public ProfileModificationsController(ProfileModificationsService service) {
        this.service = service;
    }

    @PutMapping(value="modifyUser/{userDocument}")
    public ResponseEntity<Map<String,String>> updateUser(@PathVariable String userDocument, @RequestBody CreateUserPayload entity) {
        try {
            service.update(userDocument, entity);

            Map<String, String> json = new HashMap<>();

            json.put("message", "successfully edited user");

            
            return ResponseEntity.status(HttpStatus.CREATED).body(json);

        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("Error", e.getMessage());
            
            return ResponseEntity.status(HttpStatus.CONFLICT).body(json);
        }
    }
}
