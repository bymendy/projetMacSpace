package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.service.InterventionService; // Assurez-vous d'importer le service approprié

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/rapports")
public class RapportsController {

    @Autowired
    public RapportsController(InterventionService interventionService) {
        // Injection du service
    }

    /**
     * Méthode GET pour afficher l'historique des interventions.
     *
     * @param model Le modèle utilisé pour transmettre des données à la vue.
     * @return Le nom de la vue Thymeleaf à afficher pour l'historique des interventions.
     */
    @GetMapping("/rapports")
    public String historiqueDesInterventions(Model model) {
        // Ici, vous pouvez ajouter la logique pour récupérer l'historique des interventions depuis le service
        // par exemple : List<Intervention> interventions = interventionService.getAllInterventions();
        // model.addAttribute("interventions", interventions);

        return "historiqueDesInterventions"; // Le nom de votre fichier HTML Thymeleaf
    }

    // Autres méthodes spécifiques à l'historique des interventions
}