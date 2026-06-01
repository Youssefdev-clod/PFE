package com.pharmacie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "medicaments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du médicament est obligatoire")
    @Column(unique = true, nullable = false)
    private String nom;

    @NotBlank(message = "La description est obligatoire")
    private String description;

    @NotNull(message = "Le prix est obligatoire")
    @Positive(message = "Le prix doit être positif")
    private BigDecimal prix;

    @NotNull(message = "La quantité en stock est obligatoire")
    @Positive(message = "La quantité doit être positive")
    private Integer quantiteEnStock;

    @NotNull(message = "Le niveau de réappro est obligatoire")
    @Positive(message = "Le niveau doit être positif")
    private Integer niveauDeReappro;

    @NotBlank(message = "La catégorie est obligatoire")
    private String categorie;

    @NotBlank(message = "Le code du médicament est obligatoire")
    @Column(unique = true, nullable = false)
    private String code;

    private String fabricant;
    private String dateExpiration;
    private Boolean actif = true;
}
