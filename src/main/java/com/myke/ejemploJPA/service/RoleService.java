package com.myke.ejemploJPA.service;

import com.myke.ejemploJPA.model.Role;
import com.myke.ejemploJPA.repository.IRoleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    IRoleJpaRepository iRoleJpaRepository;

    //get info del role
    public List<Role> getRoles() {
        return iRoleJpaRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return this.iRoleJpaRepository.findById(id);
    }

    //Metodo para guardar un role
    public Role addRole(Role role) {
        return this.iRoleJpaRepository.save(role);
    }

    public boolean deleteRole(Long id) {
        try {
            this.iRoleJpaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
