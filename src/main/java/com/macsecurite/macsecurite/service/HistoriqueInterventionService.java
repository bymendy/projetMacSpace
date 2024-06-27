package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.HistoriqueIntervention;
import com.macsecurite.macsecurite.repository.HistoriqueInterventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Le service HistoriqueInterventionService gère les opérations métier liées à l'historique des interventions.
 */
@Service
public class HistoriqueInterventionService {

    private  HistoriqueInterventionRepository historiqueInterventionRepository;

    ///**
    //* Constructeur du service HistoriqueInterventionService.
    //*
    //* @param historiqueInterventionRepository Le repository utilisé pour accéder aux données de l'historique des interventions dans la base de données.
    //*/
    //@Autowired
    //public HistoriqueInterventionService(HistoriqueInterventionRepository historiqueInterventionRepository) {
    //this.historiqueInterventionRepository = historiqueInterventionRepository;
    //}

    /**
     * Récupère tous les historiques d'intervention.
     *
     * @return La liste de tous les historiques d'intervention.
     */
    public List<HistoriqueIntervention> getAllHistoriquesIntervention() {
        return historiqueInterventionRepository.findAll();
    }

    // Autres méthodes spécifiques à la gestion de l'historique des interventions
}