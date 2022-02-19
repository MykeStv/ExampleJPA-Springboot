package com.myke.ejemploJPA.service;

import com.myke.ejemploJPA.model.Role;
import com.myke.ejemploJPA.repository.IRoleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    IRoleJpaRepository iRoleJpaRepository;

    //get info del role
    public List<Role> getRoles() {
        return iRoleJpaRepository.findAll();
    }

    //Metodo para guardar un role
    public Role addRole(Role role) {
        return this.iRoleJpaRepository.save(role);
    }

}
