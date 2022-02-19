package com.myke.ejemploJPA.repository;

import com.myke.ejemploJPA.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleJpaRepository extends JpaRepository<Role, Long> {
}
