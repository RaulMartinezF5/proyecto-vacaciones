package com.vacaciones.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.models.Request;
import com.vacaciones.services.employeActionsService.RequestGestionService;

@RestController
@RequestMapping(path = "/api")
public class RequestGestionController {

    private RequestGestionService requestGestionService;

    public RequestGestionController(RequestGestionService requestGestionService) {
        this.requestGestionService = requestGestionService;
    }

    @PostMapping(value = "/user/{idUser}/createRequest")
    public ResponseEntity<Map<String, String>> createNewRequest(@RequestBody Request request,
            @PathVariable String idUser) {
        try {
            requestGestionService.save(request, idUser);

            Map<String, String> json = new HashMap<>();

            json.put("message", "successfully created request");

            return ResponseEntity.status(HttpStatus.CREATED).body(json);
        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("error", e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
    }
}
