package com.myke.ejemploJPA;

import com.myke.ejemploJPA.model.Role;
import com.myke.ejemploJPA.repository.IRoleJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleJpaTest {

    @Autowired
    IRoleJpaRepository roleRepo;

    @Test
    public void RoleTest() {
        Role admin = new Role("ROLE_ADMIN");
        admin = roleRepo.save(admin);

        assertNotNull(admin);
        assertNotNull(admin.getId());
        assertEquals("ROLE_ADMIN", admin.getName());
        assertEquals(admin.getId(), roleRepo.findByName("ROLE_ADMIN").getId());
    }
}
