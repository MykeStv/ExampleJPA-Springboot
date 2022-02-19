package com.myke.ejemploJPA;

import com.myke.ejemploJPA.model.Employee;
import com.myke.ejemploJPA.model.Role;
import com.myke.ejemploJPA.repository.IEmployeeJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeJpaRepositoryTest {
    @Autowired
    private IEmployeeJpaRepository repo;

    @Test
    public void saveEmployee() {
        Role rol1 = new Role("Admin");
        Role rol2 = new Role("Engineer");
        Employee john = new Employee("John", "Smith", "empl123", rol1);
        Employee claire = new Employee("Claire", "Mitz", "empl124", rol2);

        repo.save(john);
        repo.save(claire);

        repo.flush();

        assertEquals(2, repo.findAll().size());
    }

}
