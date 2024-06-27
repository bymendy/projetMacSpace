package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.model.HistoriqueIntervention;
import com.macsecurite.macsecurite.service.HistoriqueInterventionService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Data
@Controller
public class HistoriqueInterventionController {

    private  HistoriqueInterventionService historiqueInterventionService;

    // Injection du service HistoriqueInterventionService par le constructeur
    //@Autowired
    //public HistoriqueInterventionController(HistoriqueInterventionService historiqueInterventionService) {
    // this.historiqueInterventionService = historiqueInterventionService;
    //}

    /**
     * Méthode GET pour afficher l'historique des interventions.
     *
     * @param model L'objet Model qui permet d'ajouter des attributs pour être utilisés dans la vue.
     * @return Le nom de la vue Thymeleaf à afficher.
     */
    @GetMapping("/historique-interventions")
    public String afficherHistoriqueInterventions(Model model) {
        // Appel au service pour récupérer tous les historiques d'intervention
        List<HistoriqueIntervention> historiques = historiqueInterventionService.getAllHistoriquesIntervention();

        // Ajout de la liste des historiques à l'objet Model pour être utilisé dans la vue
        model.addAttribute("historiques", historiques);

        // Retourne le nom de la vue Thymeleaf à afficher
        return "historique-interventions"; // Nom de votre fichier HTML Thymeleaf
    }
}