package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.Intervention;
import com.macsecurite.macsecurite.repository.InterventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Le service InterventionService gère les opérations métier liées aux interventions.
 */
@Service
public class InterventionService {

    private final InterventionRepository interventionRepository;

    /**
     * Constructeur du service InterventionService.
     *
     * @param interventionRepository Le repository utilisé pour accéder aux données des interventions dans la base de données.
     */
    @Autowired
    public InterventionService(InterventionRepository interventionRepository) {
        this.interventionRepository = interventionRepository;
    }

    /**
     * Planifie une intervention enregistrée dans la base de données.
     *
     * @param intervention L'intervention à planifier.
     * @return L'intervention planifiée.
     */
    public Intervention planifierIntervention(Intervention intervention) {
        return interventionRepository.save(intervention);
    }

    /**
     * Récupère toutes les interventions enregistrées dans la base de données.
     *
     * @return La liste de toutes les interventions.
     */
    public List<Intervention> getAllInterventions() {
        return interventionRepository.findAll();
    }

    // Autres méthodes spécifiques à la gestion des interventions
}