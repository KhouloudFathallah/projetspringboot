package com.example.projetkhouloud.security;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor

public class SecurityConfig {
    private UserDetailsService userDetailsServiceImp;
PasswordEncoder passwordEncoder;
    //@Bean
   /* InMemoryUserDetailsManager InMemoryUserDetailsManager()
    {
        return new InMemoryUserDetailsManager(
                User.withUsername("user").password(passwordEncoder.encode ("12345")).roles("USER").build(),
                User.withUsername("admin").password(passwordEncoder.encode ("12345")).roles("USER","ADMIN").build()
        );
    }*/
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
       // httpSecurity.formLogin(f->f.permitAll());
        httpSecurity.httpBasic(Customizer.withDefaults());
httpSecurity.authorizeHttpRequests(ar->ar.requestMatchers("/user/**").hasAuthority("USER"));
httpSecurity.authorizeHttpRequests(ar->ar.requestMatchers("/admin/**").hasAuthority("ADMIN"));
httpSecurity.exceptionHandling(ex->ex.accessDeniedPage("/errorPage"));
httpSecurity.userDetailsService(userDetailsServiceImp);
         httpSecurity.authorizeHttpRequests(ar->ar.anyRequest().authenticated());
         httpSecurity.csrf().disable();

         return httpSecurity.build();
    }


}
