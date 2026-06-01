package com.pharmacie.service;

import com.pharmacie.model.Medicament;
import com.pharmacie.repository.MedicamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MedicamentService {
    private final MedicamentRepository medicamentRepository;

    public Medicament creerMedicament(Medicament medicament) {
        return medicamentRepository.save(medicament);
    }

    public Medicament mettreAJourMedicament(Long id, Medicament medicament) {
        Medicament existing = medicamentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médicament non trouvé"));
        existing.setNom(medicament.getNom());
        existing.setDescription(medicament.getDescription());
        existing.setPrix(medicament.getPrix());
        existing.setQuantiteEnStock(medicament.getQuantiteEnStock());
        existing.setNiveauDeReappro(medicament.getNiveauDeReappro());
        existing.setCategorie(medicament.getCategorie());
        return medicamentRepository.save(existing);
    }

    public void supprimerMedicament(Long id) {
        medicamentRepository.deleteById(id);
    }

    public Medicament obtenirMedicament(Long id) {
        return medicamentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médicament non trouvé"));
    }

    public List<Medicament> obtenirTousMedicaments() {
        return medicamentRepository.findAll();
    }

    public List<Medicament> getMedicamentsAReapprovisionner() {
        return medicamentRepository.findMedicamentsAReapprovisionner();
    }

    public List<Medicament> rechercherParCategorie(String categorie) {
        return medicamentRepository.findByCategorie(categorie);
    }
}
