package com.example.projetkhouloud.security.repository;


import com.example.projetkhouloud.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole,String> {

}
