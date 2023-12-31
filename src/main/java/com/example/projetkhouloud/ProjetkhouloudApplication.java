package com.example.projetkhouloud;

import com.example.projetkhouloud.security.service.IAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjetkhouloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetkhouloudApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
   // @Bean
    CommandLineRunner commandLineRunner(IAccountService accountService){
        return args ->{
            accountService.addRole("ADMIN");
            accountService.addRole("USER");
            accountService.addUser("user","123","user@gmail.com");
            accountService.addUser("admin","123","admin@gmail.com");

            accountService.addRoleToUser("user","USER");
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("admin","USER");
        };
    }
}
