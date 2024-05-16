package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.model.Client;
import com.macsecurite.macsecurite.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Définition du contrôleur pour afficher les détails d'un client
@Controller
public class DetailsClientController {

    private final ClientService clientService;

    // Injection de dépendance du service ClientService via le constructeur
    @Autowired
    public DetailsClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Méthode GET pour récupérer et afficher les détails d'un client en fonction de son ID.
     *
     * @param clientId Identifiant du client à récupérer et afficher.
     * @param model    Objet Model pour ajouter les attributs à passer à la vue.
     * @return Nom de la vue à afficher (clientDetails.html).
     */
    @GetMapping("/clients/{clientId}")
    public String getClientDetails(@PathVariable Long clientId, Model model) {
        // Récupération du client à partir de l'ID fourni dans l'URL
        Client client = clientService.getClientById(clientId);

        // Ajout du client au modèle pour le rendre disponible dans la vue
        model.addAttribute("client", client);

        // Ajout d'autres attributs au modèle si nécessaire pour la vue

        // Renvoi du nom de la vue à afficher (clientDetails.html)
        return "clientDetails";
    }
}