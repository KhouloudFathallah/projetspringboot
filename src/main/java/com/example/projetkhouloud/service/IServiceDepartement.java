package com.example.projetkhouloud.service;

import com.example.projetkhouloud.entities.Departement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceDepartement {
    public void saveDepartement(Departement d);
    public List<Departement> getAllDepartements();
    public Page<Departement> getDepartementsByMC(String mc , Pageable p);
    public void deleteDepartement(Long id);
    public Departement getDepartement(Long id);
}
