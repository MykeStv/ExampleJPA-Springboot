package com.myke.ejemploJPA.controller;

import com.myke.ejemploJPA.model.Employee;
import com.myke.ejemploJPA.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    //Instancia la clase employee service
    @Autowired
    private EmployeeService employeeService;

    @GetMapping //Metodo de request : GET
    public List<Employee> getEmployees() {
        return this.employeeService.getEmployees();
    }

    @GetMapping(path = "/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id") Long id){
        return this.employeeService.getEmployeeById(id);
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return this.employeeService.addEmployee(employee);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return this.employeeService.addEmployee(employee);
    }

    @DeleteMapping(path = "/delite/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        if (this.employeeService.deliteEmployee(id)){
            return "Role deleted!";
        } else {
            return "Not found!";
        }
    }

}
