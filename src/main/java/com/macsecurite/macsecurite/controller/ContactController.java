package com.macsecurite.macsecurite.controller;
import com.macsecurite.macsecurite.manager.DataSourceManager;
import com.macsecurite.macsecurite.manager.TextChampManager;
import com.macsecurite.macsecurite.model.Contact;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/contact")
    public String contact(ModelMap model){
        // Création d'un nouvel objet Contact pour le formulaire avec des champs vides
        model.put("contact", new Contact());
        // Renvoie de la page contact.html avec le formulaire
        return "contact";
    }

    @PostMapping("/contact")
    public String recupContactForm(@ModelAttribute Contact contact, ModelMap model) {
        // Ajout de l'objet Contact reçu du formulaire au modèle pour l'afficher sur la page
        model.put("contact", contact);

        // Vérification du nom
        if (!TextChampManager.isNameValide(contact.getNom())) {
            // Si le nom n'est pas valide, ajout d'un message d'erreur au modèle et renvoi à la page contact
            model.put("error", "Votre nom n'est pas valide");
            return "contact";
        }

        // Vérification de l'email et du message
        // Toutes les données sont valides

        // Enregistrement dans un fichier CSV
        try {
            DataSourceManager.saveContact(contact);
        } catch (Exception ex) {
            // En cas d'erreur lors de l'enregistrement, ajout du message d'erreur au modèle
            model.put("error", ex.getMessage());
        }

        // Renvoi à la page contact après le traitement du formulaire
        return "contact";
    }
}
