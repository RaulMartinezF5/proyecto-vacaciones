package com.vacaciones.controllers.responsableActionControllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.services.responsableActionService.StateRequestsService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(path = "/api/responsable")
public class StateRequestController {
    
    private StateRequestsService service;

    public StateRequestController(StateRequestsService service) {
        this.service = service;
    }

    @PutMapping(value="/request/{idRequest}/user/{idUser}/{state}")
    public ResponseEntity<Map<String,String>> changeStateRequest(@PathVariable Long idRequest, @PathVariable String idUser, @PathVariable String state) {
        try {
            service.changeState(idUser, idRequest, state);

            Map<String, String> json = new HashMap<>();

            json.put("message", "successfully changed state of request");

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("error", e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
        
    }
}
