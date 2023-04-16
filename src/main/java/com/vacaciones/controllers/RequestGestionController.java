package com.vacaciones.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.models.Request;
import com.vacaciones.payLoads.CreateRequestPayload;
import com.vacaciones.services.employeActionsService.RequestGestionService;

@RestController
@RequestMapping(path = "/api/user")
public class RequestGestionController {

    private RequestGestionService requestGestionService;

    public RequestGestionController(RequestGestionService requestGestionService) {
        this.requestGestionService = requestGestionService;
    }

    @GetMapping(value = "/requests/{document}")
    public List<Request> userAllRequest(@PathVariable String document){
        return requestGestionService.findUserRequests(document);
    }
    
    @PostMapping(value = "/{idUser}/createRequest")
    public ResponseEntity<Map<String, String>> createNewRequest(@RequestBody CreateRequestPayload payload,
            @PathVariable String idUser) {
        try {
            requestGestionService.save(payload, idUser);

            Map<String, String> json = new HashMap<>();

            json.put("message", "successfully created request");

            return ResponseEntity.status(HttpStatus.CREATED).body(json);
        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("error", e.getMessage());
            json.put("cause", e.getLocalizedMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
    }
}
