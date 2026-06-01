package com.pharmacie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "dispensaires")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dispensaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du dispensaire est obligatoire")
    @Column(nullable = false)
    private String nom;

    @NotBlank(message = "L'adresse est obligatoire")
    private String adresse;

    private String telephone;

    @Email(message = "L'email doit être valide")
    private String email;

    @NotBlank(message = "La ville est obligatoire")
    private String ville;

    private String codePostal;
    private Boolean actif = true;
}
