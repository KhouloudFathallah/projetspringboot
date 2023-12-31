package com.example.projetkhouloud.dao;

import com.example.projetkhouloud.entities.Departement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartementRepository extends JpaRepository <Departement,Long> {
    public Page<Departement> findByNomDepContains(String mc, Pageable p);
}
