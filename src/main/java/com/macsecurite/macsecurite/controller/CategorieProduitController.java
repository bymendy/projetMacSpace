package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.model.CategorieProduit;
import com.macsecurite.macsecurite.service.CategorieProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les catégories de produit.
 */
@RestController
@RequestMapping("/categories-produit")
public class CategorieProduitController {

    private  CategorieProduitService categorieProduitService;



    //public CategorieProduitController(CategorieProduitService categorieProduitService) {
        //this.categorieProduitService = categorieProduitService;
    //}

    /**
     * Méthode POST pour créer une catégorie de produit.
     *
     * @param categorieProduit La catégorie de produit à créer.
     * @return La catégorie de produit créée.
     */
    @PostMapping("/")
    public CategorieProduit createCategorieProduit(@RequestBody CategorieProduit categorieProduit) {
        return categorieProduitService.saveCategorieProduit(categorieProduit);
    }

    /**
     * Méthode GET pour récupérer toutes les catégories de produit.
     *
     * @return Une liste contenant toutes les catégories de produit.
     */
    @GetMapping("/")
    public List<CategorieProduit> getAllCategoriesProduit() {
        return categorieProduitService.getAllCategoriesProduit();
    }

    /**
     * Méthode GET pour récupérer une catégorie de produit par son identifiant.
     *
     * @param id L'identifiant de la catégorie de produit à récupérer.
     * @return La catégorie de produit correspondant à l'identifiant spécifié.
     */
    @GetMapping("/{id}")
    public CategorieProduit getCategorieProduitById(@PathVariable Integer id) {
        return categorieProduitService.getCategorieProduitById(id);
    }

    // Ajout d'autres méthodes de contrôleur au besoin pour gérer les fonctionnalités spécifiques aux catégories de produit
}