package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.manager.DataSourceManager;
import com.macsecurite.macsecurite.manager.TextChampManager;
import com.macsecurite.macsecurite.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/") // '/' racine du projet
    public String accueil(){
        return "accueil"; // une page html
    }
    @GetMapping("/clients") // '/'
    public String gestionDesClients(){
        return "gestionDesClients"; // une page Gestion Clients
    }
    @GetMapping("/interventions") // '/'
    public String plannificatonDesInterventions(){
        return "plannificatonDesInterventions"; // une page Interventions
    }

    @GetMapping("/stocks") // '/'
    public String gestionDesStocks(){
        return "gestionDesStocks"; // une page stocks
    }

    @GetMapping("/rapports") // '/'
    public String historiqueDesInterventions(){
        return "historiqueDesInterventions"; // une page rapports
    }

    @GetMapping("/contact") // '/'
    public String contact(ModelMap model){
        model.put("contact", new Contact());// je lui envoie un formulaire avec champs vide
        return "contact"; // une page contact
    }





    @PostMapping("/contact")
    public String recupContactForm(@ModelAttribute Contact contact, ModelMap model) {
        model.put("contact", contact);
        // Verifier le nom
        if (!TextChampManager.isNameValide(contact.getNom())) {
            model.put("error", "Votre nom n'est pas valide");
            return "contact";

        }

        // je dois vérifier email et message
        // Toutes les données sont bon

        // save to csv
        try {
            DataSourceManager.saveContact(contact);
        }catch (Exception ex){
            model.put("error", ex.getMessage());
        }

        return "contact";

    }

}
