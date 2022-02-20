package com.myke.ejemploJPA;

import com.myke.ejemploJPA.model.Employee;
import com.myke.ejemploJPA.model.Project;
import com.myke.ejemploJPA.model.Role;
import com.myke.ejemploJPA.repository.IEmployeeJpaRepository;
import com.myke.ejemploJPA.repository.IProjectJpaRepository;
import com.myke.ejemploJPA.repository.IRoleJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeJpaRepositoryTest {
    @Autowired
    private IEmployeeJpaRepository repoEmployee;

    @Autowired
    private IRoleJpaRepository repoRole;

    @Autowired
    private IProjectJpaRepository repoProject;


    @Test
    public void saveEmployee() {

        Role administrador = new Role("ADMIN");
        Role developer = new Role("DEV");

        administrador = repoRole.save(administrador);
        developer = repoRole.save(developer);



        Project proj1 = new Project("proj1");
        Project proj2 = new Project("proj2");
        Project proj3 = new Project("proj3");



        proj1 = repoProject.save(proj1);
        proj2 = repoProject.save(proj2);
        proj3 = repoProject.save(proj3);

        List<Project> project1 = new ArrayList<>();
        project1.add(proj1);


        Employee john = new Employee("John", "Doe", "empl123", developer,project1);
        Employee claire = new Employee("Claire", "Simpson", "empl124", administrador,project1);


        john.getProjects().add(proj1);
        john.getProjects().add(proj2);
        john.getProjects().add(proj3);

        claire.getProjects().add(proj1);
        claire.getProjects().add(proj2);


        repoEmployee.save(john);
        repoEmployee.save(claire);

        repoEmployee.flush();

        Employee empl123  = repoEmployee.findByEmployeeid("empl123");
        Assertions.assertEquals("John", empl123.getFirstName());
        Assertions.assertEquals(2, repoEmployee.findAll().size());
        Assertions.assertEquals(developer, empl123.getRole());
    }

}
