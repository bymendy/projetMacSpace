package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.HistoriqueIntervention;
import com.macsecurite.macsecurite.repository.HistoriqueInterventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueInterventionService {

    private final HistoriqueInterventionRepository historiqueInterventionRepository;

    @Autowired
    public HistoriqueInterventionService(HistoriqueInterventionRepository historiqueInterventionRepository) {
        this.historiqueInterventionRepository = historiqueInterventionRepository;
    }

    // Méthode pour récupérer tous les historiques d'intervention
    public List<HistoriqueIntervention> getAllHistoriquesIntervention() {
        return historiqueInterventionRepository.findAll();
    }

    // Autres méthodes spécifiques à la gestion de l'historique des interventions
}