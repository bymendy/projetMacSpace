package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.model.Client;
import com.macsecurite.macsecurite.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // Cette annotation indique que ce contrôleur traite les requêtes REST
@RequestMapping("/clients") // Cette annotation spécifie le chemin de base pour les requêtes adressées à ce contrôleur
public class ClientsController {

    private final ClientService clientService; // Injection du service ClientService

    /**
     * Constructeur de la classe ClientsController.
     * Ce constructeur prend en paramètre le service ClientService et l'injecte dans le contrôleur.
     *
     * @param clientService Le service ClientService à injecter dans le contrôleur.
     */
    @Autowired // Annotation pour l'injection de dépendance
    public ClientsController(ClientService clientService) { // Constructeur prenant en paramètre le service ClientService
        this.clientService = clientService; // Initialisation du service ClientService
    }


    // Endpoint pour enregistrer un nouveau client
    /**
     * Méthode POST pour enregistrer un nouveau client.
     * Cette méthode est responsable de mapper la requête HTTP POST avec le chemin spécifié vers cette méthode.
     * Elle prend un objet Client comme corps de la requête.
     *
     * @param client Le client à enregistrer, fourni dans le corps de la requête.
     * @return Le client enregistré après l'appel à la méthode enregistrerClient du service ClientService.
     */
    @PostMapping("/") // Mapping de la méthode à une requête POST avec le chemin spécifié
    public Client enregistrerClient(@RequestBody Client client) { // Méthode pour enregistrer un nouveau client, prend le client en tant que corps de la requête (RequestBody)
        return clientService.enregistrerClient(client); // Appel à la méthode enregistrerClient du service ClientService
    }

    // Autres endpoints pour la gestion des clients
}
