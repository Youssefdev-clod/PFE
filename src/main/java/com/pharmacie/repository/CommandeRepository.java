package com.pharmacie.repository;

import com.pharmacie.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByDispensaireId(Long dispensaireId);
    List<Commande> findByStatut(Commande.StatusCommande statut);
    List<Commande> findByDateCommandeBetween(LocalDateTime debut, LocalDateTime fin);
}
