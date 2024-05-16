package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.Commande;
import com.macsecurite.macsecurite.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;

    @Autowired
    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    // Sauvegarde une commande
    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    // Récupère une commande par son identifiant
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    // Récupère toutes les commandes
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    // Autres méthodes spécifiques à la gestion des commandes
}