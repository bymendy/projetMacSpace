package com.macsecurite.macsecurite.controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
/**
 * Contrôleur pour gérer les rapports.
 */
public class RapportsController {

    /**
     * Méthode GET pour afficher l'historique des interventions.
     *
     * @return Le nom de la vue Thymeleaf à afficher pour l'historique des interventions.
     */
    @GetMapping("/rapports")
    public String historiqueDesInterventions() {
        return "historiqueDesInterventions";
    }

    // Autres méthodes spécifiques à l'historique des interventions
}