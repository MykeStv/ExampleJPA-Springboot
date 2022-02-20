package com.myke.ejemploJPA.service;

import com.myke.ejemploJPA.model.Employee;
import com.myke.ejemploJPA.repository.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    //Instancia la interface employee ropository
    @Autowired
    private IEmployeeJpaRepository iEmployeeJpaRepository;

    //metodo que obtiene todos los employee
    public List<Employee> getEmployees() {
        return this.iEmployeeJpaRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return this.iEmployeeJpaRepository.findById(id);
    }

    //Agrega un empleado
    public Employee addEmployee(Employee employee) {
        return this.iEmployeeJpaRepository.save(employee);
    }

    public boolean deliteEmployee(Long id) {
        try {
            this.iEmployeeJpaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
