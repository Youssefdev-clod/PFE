package com.pharmacie.controller;

import com.pharmacie.model.Medicament;
import com.pharmacie.service.MedicamentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicaments")
@RequiredArgsConstructor
@Tag(name = "Medicaments", description = "API de gestion des médicaments")
public class MedicamentController {
    private final MedicamentService medicamentService;

    @PostMapping
    @Operation(summary = "Créer un nouveau médicament")
    public ResponseEntity<Medicament> creerMedicament(@Valid @RequestBody Medicament medicament) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(medicamentService.creerMedicament(medicament));
    }

    @GetMapping
    @Operation(summary = "Récupérer tous les médicaments")
    public ResponseEntity<List<Medicament>> obtenirTousMedicaments() {
        return ResponseEntity.ok(medicamentService.obtenirTousMedicaments());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un médicament par ID")
    public ResponseEntity<Medicament> obtenirMedicament(@PathVariable Long id) {
        return ResponseEntity.ok(medicamentService.obtenirMedicament(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un médicament")
    public ResponseEntity<Medicament> mettreAJourMedicament(
            @PathVariable Long id,
            @Valid @RequestBody Medicament medicament) {
        return ResponseEntity.ok(medicamentService.mettreAJourMedicament(id, medicament));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un médicament")
    public ResponseEntity<Void> supprimerMedicament(@PathVariable Long id) {
        medicamentService.supprimerMedicament(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reappro/alerte")
    @Operation(summary = "Récupérer les médicaments à réapprovisionner")
    public ResponseEntity<List<Medicament>> getMedicamentsAReapprovisionner() {
        return ResponseEntity.ok(medicamentService.getMedicamentsAReapprovisionner());
    }

    @GetMapping("/categorie/{categorie}")
    @Operation(summary = "Récupérer les médicaments par catégorie")
    public ResponseEntity<List<Medicament>> getMedicamentsParCategorie(@PathVariable String categorie) {
        return ResponseEntity.ok(medicamentService.rechercherParCategorie(categorie));
    }
}
