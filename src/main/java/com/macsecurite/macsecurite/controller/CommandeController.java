package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.model.Commande;
import com.macsecurite.macsecurite.service.CommandeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private  CommandeService commandeService;

    ///**
    // * Constructeur de la classe CommandeController.
    // * Ce constructeur est utilisé pour injecter le service CommandeService via l'injection de dépendance.
    // *
    //* @param commandeService Le service CommandeService à injecter.
    //*/
    //@Autowired
    //public CommandeController(CommandeService commandeService) {
    //this.commandeService = commandeService;
    //}


    // Méthode POST pour créer une commande
    /**
     * Méthode POST pour créer une commande.
     * Cette méthode permet de créer une nouvelle commande dans le système en utilisant les données fournies dans le corps de la requête HTTP.
     *
     * @param commande L'objet Commande représentant les informations de la commande à créer.
     * @return Retourne l'objet Commande créé avec les détails sauvegardés dans le système.
     */
    @PostMapping("/")
    public Commande createCommande(@RequestBody Commande commande) {
        return commandeService.saveCommande(commande);
    }

    // Méthode GET pour récupérer toutes les commandes
    /**
     * Méthode GET pour récupérer toutes les commandes.
     * Cette méthode permet de récupérer toutes les commandes existantes dans le système.
     *
     * @return Retourne une liste contenant toutes les commandes présentes dans le système.
     */
    @GetMapping("/")
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }


    // Méthode GET pour récupérer une commande par son identifiant
    /**
     * Méthode GET pour récupérer une commande par son identifiant.
     * Cette méthode permet de récupérer une commande spécifique à partir de son identifiant.
     *
     * @param id L'identifiant de la commande à récupérer.
     * @return Retourne la commande correspondant à l'identifiant spécifié, ou null si aucune commande n'est trouvée.
     */
    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable Integer id) {
        return commandeService.getCommandeById(id);
    }

    // Ajout d'autres méthodes de contrôleur au besoin pour gérer les fonctionnalités spécifiques aux commandes
}