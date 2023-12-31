package com.example.projetkhouloud.dao;

import com.example.projetkhouloud.entities.Employee;
import com.example.projetkhouloud.entities.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission,Long> {
    Mission findByName(String name);
    public Page<Mission> findByNameContains(String mc, Pageable p);
}
