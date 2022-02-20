package com.myke.ejemploJPA.controller;

import com.myke.ejemploJPA.model.Role;
import com.myke.ejemploJPA.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @GetMapping(path = "/{id}")
    public Optional<Role> getRole(@PathVariable("id") Long id) {
        return this.roleService.getRoleById(id);
    }

    @PostMapping(path = "/add")
    public Role addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @PutMapping(path = "/update")
    public Role updateRole(@RequestBody Role role) {
        return this.roleService.addRole(role);
    }

    @DeleteMapping(path = "/delite/{id}")
    public String deleteRole(@PathVariable("id") Long id) {
        if (this.roleService.deleteRole(id)){
            return "Role deleted!";
        } else {
            return "Not found!";
        }
    }

    /*@DeleteMapping(path = "/delite/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable("id") Long id) {
        if (this.roleService.deleteRole(id)){
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound(null); //??
        }
    }*/


}
