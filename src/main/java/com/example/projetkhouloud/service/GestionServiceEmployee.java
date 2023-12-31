package com.example.projetkhouloud.service;

import com.example.projetkhouloud.dao.EmployeeRepository;
import com.example.projetkhouloud.dao.MissionRepository;
import com.example.projetkhouloud.entities.Employee;
import com.example.projetkhouloud.entities.Mission;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@AllArgsConstructor
public class GestionServiceEmployee implements IServiceEmployee{
    EmployeeRepository employeeRepository;
    MissionRepository missionRepository;
    @Override
    public void saveEmployee(Employee e, MultipartFile mf) throws IOException {
        if(!mf.isEmpty())
            e.setPhoto(saveImage(mf));


        employeeRepository.save(e);

    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> getEmployeesByMC(String mc, Pageable p) {
        return employeeRepository.findByNomContains(mc,p);
    }

    @Override
    public List<Employee> getEmployeesByDep(Long idDep) {
        return employeeRepository.getEmployeesByDepartement(idDep);
    }

    @Override
    public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);

    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void addMissiontoEmployee(String nameMission, String nameEmployee) {
        Employee employee = employeeRepository.findByNom(nameEmployee);
        Mission mission = missionRepository.findByName(nameMission);
        employee.getMissions().add(mission);
        employeeRepository.save(employee);

    }

    private String saveImage(MultipartFile mf) throws IOException {
        String nom=mf.getOriginalFilename();
        String tab[]=nom.split("\\.");
        String newName=tab[0]+System.currentTimeMillis()+"."+tab[1];
        File f =new ClassPathResource("static/photo").getFile();
        String chemin=f.getAbsolutePath();
        Path p= Paths.get(chemin,newName);
        Files.write(p,mf.getBytes());
        return newName;
    }


}
