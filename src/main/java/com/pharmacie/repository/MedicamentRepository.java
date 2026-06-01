package com.pharmacie.repository;

import com.pharmacie.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
    Optional<Medicament> findByCode(String code);
    List<Medicament> findByCategorie(String categorie);
    List<Medicament> findByNomContainingIgnoreCase(String nom);
    
    @Query("SELECT m FROM Medicament m WHERE m.quantiteEnStock < m.niveauDeReappro AND m.actif = true")
    List<Medicament> findMedicamentsAReapprovisionner();
}
