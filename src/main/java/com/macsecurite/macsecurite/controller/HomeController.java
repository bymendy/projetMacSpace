package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.manager.DataSourceManager;
import com.macsecurite.macsecurite.manager.TextChampManager;
import com.macsecurite.macsecurite.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

    // VUE :

    // La vue représente l'interface utilisateur dans une application logicielle.
    // Elle affiche les informations à l'utilisateur et gère les interactions avec celui-ci.
    //
    //******
    //Vue : C'est comme une fenêtre par laquelle tu regardes à l'intérieur
    // de ton jeu vidéo préféré. C'est là où tu vois tout ce qui se passe
    // et où tu interagis avec le jeu.
    //******


    //UNE CLASSE :

    //En programmation orientée objet, une classe est un modèle pour créer des objets.
    // Elle définit les propriétés (attributs) et les comportements (méthodes)
    // des objets qui seront créés à partir d'elle.
    //
    //******
    //Imagine que tu as une boîte à outils avec plein d'outils différents dedans.
    // Chaque outil a un nom et fait quelque chose spécifique.
    // Une classe, c'est un peu comme une boîte à outils pour les ordinateurs.
    // Elle contient des instructions sur ce que l'ordinateur peut faire.
    //******

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

}
