package com.vacaciones.controllers.adminActionControllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.models.User;
import com.vacaciones.services.adminActionsServices.AdminCreateTeamsService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(path = "/api/admin")
public class AdminCreateTeamsController {
    
    private AdminCreateTeamsService adminCreateTeamsService;

    public AdminCreateTeamsController(AdminCreateTeamsService adminCreateTeamsService) {
        this.adminCreateTeamsService = adminCreateTeamsService;
    }

    @PutMapping(value="/createTeams/responsable/{idResponsable}/employe/{idEmploye}")
    public ResponseEntity<Map<String, String>> createTeams(@PathVariable String idResponsable, @PathVariable String idEmploye) {
        try {
            User userDB = adminCreateTeamsService.asignEmployesToResponsable(idResponsable, idEmploye);
            
            Map<String, String> json = new HashMap<>();

            json.put("message", "successfully added user");
            json.put("user", userDB.getProfile().getFirstName());

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("error", e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
        }
    }
}
