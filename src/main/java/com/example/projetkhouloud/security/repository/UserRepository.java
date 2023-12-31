package com.example.projetkhouloud.security.repository;


import com.example.projetkhouloud.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,String> {
    public AppUser findAppUserByUserName(String userName);
}
