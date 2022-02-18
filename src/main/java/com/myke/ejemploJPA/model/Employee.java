package com.myke.ejemploJPA.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee {

    //ATTRIBUTES
    @Id //anotacion para decir que es un id
    @GeneratedValue(strategy = GenerationType.AUTO) //el id será autogenerado por el motor de db
    private Long id;

    @Column(length = 25, nullable = false) //25 caracteres y que es NOT NULL
    private String firstName;

    @Column(length = 25, nullable = false)
    private String lastName;

    @Column(length = 10, nullable = false, unique = true) //es unico y 10 caracteres
    private String employeeid;

    //CONSTRUCTOR
    public Employee() {
    }

    public Employee(String firstName, String lastName, String employeeid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeid = employeeid;
    }

    //GETTER && SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    //Equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //toString
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeeid='" + employeeid + '\'' +
                '}';
    }
}
