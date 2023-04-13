package com.vacaciones.controllers.adminActionControllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.services.adminActionsServices.ProfileModificationsService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "/api/admin")
public class FireUserController {
    private ProfileModificationsService service;

    public FireUserController(ProfileModificationsService service) {
        this.service = service;
    }

    @PutMapping(value = "/fireUser/{document}")
    public ResponseEntity<Map<String, String>> fireUser(@PathVariable String document) {
        try {
            service.fireUser(document);

            Map<String, String> json = new HashMap<>();

            json.put("message", "successfully fired user");

            return ResponseEntity.status(HttpStatus.CREATED).body(json);
        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("Error", e.getMessage());

            return ResponseEntity.status(HttpStatus.CONFLICT).body(json);
        }
    }

    @PutMapping(value = "/restoreUser/{document}")
    public ResponseEntity<Map<String, String>> restoreUser(@PathVariable String document) {
        try {
            service.restoreUser(document);

            Map<String, String> json = new HashMap<>();

            json.put("message", "successfully restored user");

            return ResponseEntity.status(HttpStatus.CREATED).body(json);
        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("Error", e.getMessage());

            return ResponseEntity.status(HttpStatus.CONFLICT).body(json);
        }
    }
}
