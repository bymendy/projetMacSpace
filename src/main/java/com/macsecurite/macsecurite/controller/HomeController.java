package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.manager.DataSourceManager;
import com.macsecurite.macsecurite.manager.TextChampManager;
import com.macsecurite.macsecurite.model.Contact;
import com.macsecurite.macsecurite.model.Role;
import com.macsecurite.macsecurite.model.Users;
import com.macsecurite.macsecurite.service.RoleService;
import com.macsecurite.macsecurite.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

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
@Data
/**
 * Contrôleur pour gérer les pages principales de l'application.
 */
@Controller
public class HomeController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Méthode GET pour afficher la page d'accueil.
     * Cette méthode crée un compte utilisateur avec un rôle "CLIENT".
     *
     * @return Le nom de la vue Thymeleaf pour la page d'accueil.
     */
    @GetMapping
    public String home() {
        // Créer un compte
        /*Role role = new Role();
        role.setName("CLIENT");
        roleService.saveRole(role);

        Users users = new Users();
        users.setEmail("a@a.fr");
        users.setPassword(bCryptPasswordEncoder.encode("admin"));
        users.setRoles(List.of(role));
        users.setName("Admin");

        userService.saveUser(users); */

        return "home";
    }


    /*@GetMapping("/login")
    public String login(){
        return "login";
    }*/

    @PostMapping("/register")
    public String register(@ModelAttribute Users users, HttpServletRequest request){
        users.setActive(true);
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        users.setRoles(List.of(roleService.getRole(RoleService.ROLE.CLIENT)));

        users = userService.saveUser(users);

        // creer la session
      Authentication authentication = new UsernamePasswordAuthenticationToken(users, null, users.getAuthorities());
        SecurityContext sc = SecurityContextHolder.getContext();
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);


        return "redirect:/client";
    }

    /**
     * Méthode GET pour afficher la page d'accueil principale.
     *
     * @return Le nom de la vue Thymeleaf pour la page d'accueil principale.
     */
    @GetMapping("/") // '/' racine du projet
    public String accueil() {
        return "accueil"; // une page html
    }

    /**
     * Méthode GET pour afficher la page de gestion des clients.
     *
     * @return Le nom de la vue Thymeleaf pour la gestion des clients.
     */
    @GetMapping("/clients") // '/'
    public String gestionDesClients() {
        return "gestionDesClients"; // une page Gestion Clients
    }

    /**
     * Méthode GET pour afficher la page de planification des interventions.
     *
     * @return Le nom de la vue Thymeleaf pour la planification des interventions.
     */
    @GetMapping("/interventions") // '/'
    public String plannificatonDesInterventions() {
        return "plannificatonDesInterventions"; // une page Interventions
    }

    /**
     * Méthode GET pour afficher la page de gestion des stocks.
     *
     * @return Le nom de la vue Thymeleaf pour la gestion des stocks.
     */
    @GetMapping("/stocks") // '/'
    public String gestionDesStocks() {
        return "gestionDesStocks"; // une page stocks
    }

    /**
     * Méthode GET pour afficher la page de l'historique des interventions.
     *
     * @return Le nom de la vue Thymeleaf pour l'historique des interventions.
     */
    @GetMapping("/rapports") // '/'
    public String historiqueDesInterventions() {
        return "historiqueDesInterventions"; // une page rapports
    }
}