package com.myke.ejemploJPA;

import com.myke.ejemploJPA.model.Project;
import com.myke.ejemploJPA.repository.IProjectJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProjectJpaTest {
    @Autowired
    IProjectJpaRepository projRepo;

    @Test
    public void projectTest() {
        Project proj1 = new Project("PROJECT1");
        proj1 = projRepo.save(proj1);
        assertNotNull(proj1);
        assertNotNull(proj1.getId());
        assertEquals("PROJECT1", proj1.getName());
        assertEquals(proj1.getId(), projRepo.findByName("PROJECT1").getId());
    }
}