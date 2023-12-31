package com.example.projetkhouloud.service;

import com.example.projetkhouloud.dao.DepartementRepository;
import com.example.projetkhouloud.entities.Departement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class GestionServiceDepartement implements IServiceDepartement{
    DepartementRepository departementRepository;
    @Override
    public void saveDepartement(Departement d) {
        departementRepository.save(d);

    }

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }



    @Override
    public Page <Departement> getDepartementsByMC(String mc, Pageable p) {
        return departementRepository.findByNomDepContains(mc,p);
    }

    @Override
    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);

    }

    @Override
    public Departement getDepartement(Long id) {
        return departementRepository.findById(id).orElse(null);
    }
}
