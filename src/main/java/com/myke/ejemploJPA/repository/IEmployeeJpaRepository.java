package com.myke.ejemploJPA.repository;

import com.myke.ejemploJPA.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee, Long> {

    //Select fields from employee where employeeid='[param]'
    Employee findByEmployeeid(String employeeid);

}
