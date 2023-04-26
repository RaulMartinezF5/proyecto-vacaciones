package com.vacaciones.controllers.adminActionControllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.models.User;
import com.vacaciones.services.adminActionsServices.ViewAllUserService;

@RestController
@RequestMapping(path = "/api/admin")

public class ViewAllUserController {

    private ViewAllUserService service;

    public ViewAllUserController(ViewAllUserService service) {
        this.service = service;
    }

    @GetMapping(value = "/allusers")
    public List<User> allList() {
        return service.allList();

    }
}
