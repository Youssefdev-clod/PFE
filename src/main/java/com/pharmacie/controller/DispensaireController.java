package com.pharmacie.controller;

import com.pharmacie.model.Dispensaire;
import com.pharmacie.repository.DispensaireRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispensaires")
@RequiredArgsConstructor
@Tag(name = "Dispensaires", description = "API de gestion des dispensaires")
public class DispensaireController {
    private final DispensaireRepository dispensaireRepository;

    @PostMapping
    @Operation(summary = "Créer un nouveau dispensaire")
    public ResponseEntity<Dispensaire> creerDispensaire(@Valid @RequestBody Dispensaire dispensaire) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dispensaireRepository.save(dispensaire));
    }

    @GetMapping
    @Operation(summary = "Récupérer tous les dispensaires")
    public ResponseEntity<List<Dispensaire>> obtenirTousDispensaires() {
        return ResponseEntity.ok(dispensaireRepository.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un dispensaire par ID")
    public ResponseEntity<Dispensaire> obtenirDispensaire(@PathVariable Long id) {
        return ResponseEntity.ok(dispensaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispensaire non trouvé")));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un dispensaire")
    public ResponseEntity<Dispensaire> mettreAJourDispensaire(
            @PathVariable Long id,
            @Valid @RequestBody Dispensaire dispensaire) {
        Dispensaire existing = dispensaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispensaire non trouvé"));
        existing.setNom(dispensaire.getNom());
        existing.setAdresse(dispensaire.getAdresse());
        existing.setTelephone(dispensaire.getTelephone());
        existing.setEmail(dispensaire.getEmail());
        existing.setVille(dispensaire.getVille());
        return ResponseEntity.ok(dispensaireRepository.save(existing));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un dispensaire")
    public ResponseEntity<Void> supprimerDispensaire(@PathVariable Long id) {
        dispensaireRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
