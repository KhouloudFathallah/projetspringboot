package com.example.projetkhouloud.service;

import com.example.projetkhouloud.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IServiceEmployee {
    public void saveEmployee(Employee e, MultipartFile mf) throws IOException;
    public List<Employee> getAllEmployees();

    public Page<Employee> getEmployeesByMC(String mc, Pageable p);
    public List<Employee> getEmployeesByDep(Long idDep);
    public void deleteEmployee(Long id);
    public Employee getEmployee(Long id);
    void addMissiontoEmployee (String nameMission , String nameEmployee);
}
