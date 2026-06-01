package com.pharmacie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "commandes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Le dispensaire est obligatoire")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dispensaire_id", nullable = false)
    private Dispensaire dispensaire;

    @Column(nullable = false)
    private LocalDateTime dateCommande;

    @Column(nullable = false)
    private LocalDateTime dateExpedition;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusCommande statut = StatusCommande.EN_ATTENTE;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LigneCommande> lignes = new ArrayList<>();

    private BigDecimal montantTotal;

    private String remarques;

    public enum StatusCommande {
        EN_ATTENTE, CONFIRMEE, EXPEDIE, LIVREE, ANNULEE
    }
}
