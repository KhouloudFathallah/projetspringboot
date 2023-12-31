package com.example.projetkhouloud.dao;

import com.example.projetkhouloud.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public Page<Employee> findByNomContains(String mc, Pageable p);
    @Query("select e from Employee e where e.departement.id=:x")
    public List<Employee> getEmployeesByDepartement(@Param("x") Long idC);
    Employee findByNom(String nom);
}
