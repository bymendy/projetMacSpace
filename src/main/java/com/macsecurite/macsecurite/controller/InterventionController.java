package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.model.Intervention;
import com.macsecurite.macsecurite.service.InterventionService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RestController
@RequestMapping("/interventions")
/**
 * Contrôleur pour gérer les interventions.
 */
public class InterventionController {

    private  InterventionService interventionService;

    ///**
    // * Constructeur pour l'injection de dépendance du service InterventionService.
    //// *
    //* @param interventionService Le service InterventionService à injecter.
    // */
    //@Autowired
    //public InterventionController(InterventionService interventionService) {
    // this.interventionService = interventionService;
    //}

    /**
     * Endpoint pour planifier une nouvelle intervention.
     *
     * @param intervention L'intervention à planifier.
     * @return L'intervention planifiée.
     */
    @PostMapping("/")
    public Intervention planifierIntervention(@RequestBody Intervention intervention) {
        return interventionService.planifierIntervention(intervention);
    }

    /**
     * Endpoint pour obtenir toutes les interventions.
     *
     * @return La liste de toutes les interventions.
     */
    @GetMapping("/")
    public List<Intervention> getAllInterventions() {
        return interventionService.getAllInterventions();
    }

    // Autres endpoints pour la gestion des interventions
}