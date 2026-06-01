package com.pharmacie.repository;

import com.pharmacie.model.Dispensaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DispensaireRepository extends JpaRepository<Dispensaire, Long> {
    Optional<Dispensaire> findByEmail(String email);
    List<Dispensaire> findByVille(String ville);
    List<Dispensaire> findByNomContainingIgnoreCase(String nom);
    List<Dispensaire> findByActifTrue();
}
