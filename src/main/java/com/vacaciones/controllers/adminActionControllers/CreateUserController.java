package com.vacaciones.controllers.adminActionControllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.payLoads.CreateUserPayload;
import com.vacaciones.services.adminActionsServices.ProfileRegisterService;

@RestController
@RequestMapping(path = "/api/admin")
public class CreateUserController {

    private ProfileRegisterService service;

    public CreateUserController(ProfileRegisterService service) {
        this.service = service;
    }

    @PostMapping(value = "/createUser")
    public ResponseEntity<Map<String, String>> createUserAndProfile(@RequestBody CreateUserPayload payload) {
        try {
            service.createUserAndProfile(payload);

            Map<String, String> json = new HashMap<>();

            json.put("message", "successfully registered user");

            
            return ResponseEntity.status(HttpStatus.CREATED).body(json);

        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("Error", e.getMessage());
            
            return ResponseEntity.status(HttpStatus.CONFLICT).body(json);
        }
    }
}
