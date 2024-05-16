package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.Client;
import com.macsecurite.macsecurite.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Annotation indiquant que cette classe est un service Spring
@Service
public class ClientService {

    // Injection de dépendance du repository ClientRepository
    private final ClientRepository clientRepository;

    // Constructeur de la classe ClientService, injecte ClientRepository via l'injection de dépendance
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Méthode de service pour enregistrer un nouveau client
    public Client enregistrerClient(Client client) {
        // Utilisation de la méthode save() du repository pour enregistrer le client
        return clientRepository.save(client);
    }

    // Méthode pour récupérer un client par son identifiant
    public Client getClientById(Long id) {
        // Utilisation de la méthode findById() du repository pour rechercher le client par son identifiant
        // Si le client n'est pas trouvé, retourne null
        return clientRepository.findById(id).orElse(null);
    }

    // Autres méthodes spécifiques à la gestion des clients
}