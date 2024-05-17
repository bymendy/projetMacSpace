package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.Commande;
import com.macsecurite.macsecurite.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Le service CommandeService est responsable de la gestion des commandes et fournit des fonctionnalités associées.
 */
@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;

    /**
     * Constructeur du service CommandeService.
     *
     * @param commandeRepository Le repository utilisé pour accéder aux données des commandes.
     */
    @Autowired
    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    /**
     * Sauvegarde une commande dans la base de données.
     *
     * @param commande La commande à sauvegarder.
     * @return La commande sauvegardée.
     */
    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    /**
     * Récupère une commande par son identifiant.
     *
     * @param id L'identifiant de la commande à récupérer.
     * @return La commande correspondant à l'identifiant spécifié, ou null si aucune commande n'est trouvée.
     */
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    /**
     * Récupère toutes les commandes présentes dans la base de données.
     *
     * @return Une liste contenant toutes les commandes.
     */
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    // Autres méthodes spécifiques à la gestion des commandes
}