package com.vacaciones.controllers.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.services.UserService;


@RestController
@RequestMapping(path = "/api")
public class AuthController {

    private UserService service;

    
    
    public AuthController(UserService service) {
        this.service = service;
    }



    @GetMapping(value = "/login")
    public ResponseEntity<Map<String,String>> acces() {
        var auth = SecurityContextHolder.getContext().getAuthentication();

        if(service.findByDocument(auth.getName()).getContractedUser().equals("inactive")) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        Map<String, String> json = new HashMap<>();

        String role = auth.getAuthorities().iterator().next().toString();

        if(auth.getAuthorities().size() > 1){
            for (GrantedAuthority authority : auth.getAuthorities()) {
                System.out.println(authority.getAuthority());
                if(authority.getAuthority().equals("ROLE_RESPONSABLE")) role = authority.getAuthority();
            }
        }

        json.put("message", "logged");
        json.put("username", auth.getName());
        json.put("role", role);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
    }
}
