package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.Client;
import com.macsecurite.macsecurite.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Cette classe représente la logique métier associée aux clients.
 */
@Service
public class ClientService {

    // Repository pour accéder aux données des clients
    private  ClientRepository clientRepository;

    ///**
    //* Constructeur de la classe ClientService.
    //*
    // * @param clientRepository Le repository des clients
    // */
    //@Autowired
    //public ClientService(ClientRepository clientRepository) {
    //   this.clientRepository = clientRepository;
    //}

    /**
     * Enregistre un nouveau client.
     *
     * @param client Le client à enregistrer
     * @return Le client enregistré
     */
    public Client enregistrerClient(Client client) {
        return clientRepository.save(client);
    }

    /**
     * Récupère un client par son identifiant.
     *
     * @param id L'identifiant du client à récupérer
     * @return Le client trouvé, ou null s'il n'existe aucun client correspondant à l'identifiant
     */
    public Client getClientById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    // Autres méthodes spécifiques à la gestion des clients

    


}