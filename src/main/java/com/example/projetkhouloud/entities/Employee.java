package com.example.projetkhouloud.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 1, max = 20)
    private String nom;
    @NotEmpty
    @Size(min = 1, max = 20)
    private String prenom;
    @NotEmpty
    @Size(min = 1, max = 8)
    private String cin;
    @ManyToOne
    @NotNull(message = "La departement ne doit pas être vide")
    private Departement departement;
    private String photo;

    @ManyToMany(mappedBy = "employees")
    private Set<Mission> missions;

}
