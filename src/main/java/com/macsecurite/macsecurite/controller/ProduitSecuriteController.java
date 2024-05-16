package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.model.ProduitSecurite;
import com.macsecurite.macsecurite.service.ProduitSecuriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits-securite")
/**
 * Contrôleur pour gérer les produits de sécurité.
 */
public class ProduitSecuriteController {

    private final ProduitSecuriteService produitSecuriteService;

    /**
     * Constructeur pour l'injection de dépendance du service ProduitSecuriteService.
     *
     * @param produitSecuriteService Le service ProduitSecuriteService à injecter.
     */
    @Autowired
    public ProduitSecuriteController(ProduitSecuriteService produitSecuriteService) {
        this.produitSecuriteService = produitSecuriteService;
    }

    /**
     * Méthode POST pour créer un produit de sécurité.
     *
     * @param produitSecurite Le produit de sécurité à créer.
     * @return Le produit de sécurité créé.
     */
    @PostMapping("/")
    public ProduitSecurite createProduitSecurite(@RequestBody ProduitSecurite produitSecurite) {
        return produitSecuriteService.saveProduitSecurite(produitSecurite);
    }

    /**
     * Méthode GET pour récupérer tous les produits de sécurité.
     *
     * @return La liste de tous les produits de sécurité.
     */
    @GetMapping("/")
    public List<ProduitSecurite> getAllProduitsSecurite() {
        return produitSecuriteService.getAllProduitsSecurite();
    }

    /**
     * Méthode GET pour récupérer un produit de sécurité par son identifiant.
     *
     * @param id L'identifiant du produit de sécurité à récupérer.
     * @return Le produit de sécurité correspondant à l'identifiant donné.
     */
    @GetMapping("/{id}")
    public ProduitSecurite getProduitSecuriteById(@PathVariable Long id) {
        return produitSecuriteService.getProduitSecuriteById(id);
    }

    // Ajout d'autres méthodes de contrôleur au besoin pour gérer les fonctionnalités spécifiques aux produits de sécurité
}
