package com.example.projetkhouloud.security.service;


import com.example.projetkhouloud.security.entities.AppUser;

public interface IAccountService {
    public void addRole(String role);
    public void addUser(String userName,String passWord,String mail);
    public void addRoleToUser(String user,String role);
    public AppUser getUserByUserName(String userName);
}
