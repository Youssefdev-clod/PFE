package com.pharmacie.service;

import com.pharmacie.model.Commande;
import com.pharmacie.repository.CommandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandeService {
    private final CommandeRepository commandeRepository;

    public Commande creerCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public Commande obtenirCommande(Long id) {
        return commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));
    }

    public List<Commande> obtenirToutesCommandes() {
        return commandeRepository.findAll();
    }

    public List<Commande> getCommandesByDispensaire(Long dispensaireId) {
        return commandeRepository.findByDispensaireId(dispensaireId);
    }

    public List<Commande> getCommandesByStatut(Commande.StatusCommande statut) {
        return commandeRepository.findByStatut(statut);
    }

    public Commande updateStatutCommande(Long id, Commande.StatusCommande newStatut) {
        Commande commande = obtenirCommande(id);
        commande.setStatut(newStatut);
        return commandeRepository.save(commande);
    }
}
