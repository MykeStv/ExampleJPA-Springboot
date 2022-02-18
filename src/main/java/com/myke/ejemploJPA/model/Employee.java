package com.myke.ejemploJPA.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id //anotacion para decir que es un id
    @GeneratedValue(strategy = GenerationType.AUTO) //el id será autogenerado por el motor de db
    private Long id;
}
