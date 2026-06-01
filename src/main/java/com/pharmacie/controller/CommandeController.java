package com.pharmacie.controller;

import com.pharmacie.model.Commande;
import com.pharmacie.service.CommandeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
@RequiredArgsConstructor
@Tag(name = "Commandes", description = "API de gestion des commandes")
public class CommandeController {
    private final CommandeService commandeService;

    @PostMapping
    @Operation(summary = "Créer une nouvelle commande")
    public ResponseEntity<Commande> creerCommande(@Valid @RequestBody Commande commande) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commandeService.creerCommande(commande));
    }

    @GetMapping
    @Operation(summary = "Récupérer toutes les commandes")
    public ResponseEntity<List<Commande>> obtenirToutesCommandes() {
        return ResponseEntity.ok(commandeService.obtenirToutesCommandes());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une commande par ID")
    public ResponseEntity<Commande> obtenirCommande(@PathVariable Long id) {
        return ResponseEntity.ok(commandeService.obtenirCommande(id));
    }

    @GetMapping("/dispensaire/{dispensaireId}")
    @Operation(summary = "Récupérer les commandes d'un dispensaire")
    public ResponseEntity<List<Commande>> getCommandesByDispensaire(@PathVariable Long dispensaireId) {
        return ResponseEntity.ok(commandeService.getCommandesByDispensaire(dispensaireId));
    }

    @GetMapping("/statut/{statut}")
    @Operation(summary = "Récupérer les commandes par statut")
    public ResponseEntity<List<Commande>> getCommandesByStatut(@PathVariable String statut) {
        return ResponseEntity.ok(commandeService.getCommandesByStatut(
                Commande.StatusCommande.valueOf(statut)));
    }

    @PatchMapping("/{id}/statut")
    @Operation(summary = "Mettre à jour le statut d'une commande")
    public ResponseEntity<Commande> updateStatut(
            @PathVariable Long id,
            @RequestParam String statut) {
        return ResponseEntity.ok(commandeService.updateStatutCommande(id,
                Commande.StatusCommande.valueOf(statut)));
    }
}
