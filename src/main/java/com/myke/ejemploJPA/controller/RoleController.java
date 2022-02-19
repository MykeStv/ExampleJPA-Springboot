package com.myke.ejemploJPA.controller;

import com.myke.ejemploJPA.model.Role;
import com.myke.ejemploJPA.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @PostMapping(path = "/add")
    public Role addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

}
