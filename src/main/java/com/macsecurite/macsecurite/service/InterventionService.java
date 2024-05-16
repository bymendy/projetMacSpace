package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.Intervention;
import com.macsecurite.macsecurite.repository.InterventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterventionService {

    private final InterventionRepository interventionRepository;

    @Autowired
    public InterventionService(InterventionRepository interventionRepository) {
        this.interventionRepository = interventionRepository;
    }

    // Méthode pour planifier une intervention
    public Intervention planifierIntervention(Intervention intervention) {
        return interventionRepository.save(intervention);
    }

    // Méthode pour obtenir toutes les interventions
    public List<Intervention> getAllInterventions() {
        return interventionRepository.findAll();
    }

    // Autres méthodes spécifiques à la gestion des interventions
}