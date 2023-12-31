package com.example.projetkhouloud.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String period;
    @ManyToMany
    private Set<Employee> employees;
    public void addempl(Employee employee) {
        if (this.employees ==null ) {this.employees = new HashSet<Employee>();}
        this.employees.add(employee);
        if ( employee.getMissions()==null )
        {employee.setMissions(new HashSet<Mission>());}
        employee.getMissions().add(this);
    }
}