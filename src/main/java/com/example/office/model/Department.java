package com.example.office.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.CascadeType;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Employee> employee;

    public Department(String name) {
        this.name = name;
    }
    


    
}
