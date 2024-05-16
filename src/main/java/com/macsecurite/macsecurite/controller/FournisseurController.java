package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.model.Fournisseur;
import com.macsecurite.macsecurite.model.ProduitSecurite;
import com.macsecurite.macsecurite.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

    private final FournisseurService fournisseurService;

    @Autowired
    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    /**
     * Méthode POST pour créer un nouveau fournisseur.
     *
     * @param fournisseur Le fournisseur à créer.
     * @return Le fournisseur créé.
     */
    @PostMapping("/")
    public Fournisseur createFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.saveFournisseur(fournisseur);
    }

    /**
     * Méthode GET pour récupérer tous les fournisseurs.
     *
     * @return La liste de tous les fournisseurs.
     */
    @GetMapping("/")
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurService.getAllFournisseurs();
    }

    /**
     * Méthode GET pour récupérer un fournisseur par son identifiant.
     *
     * @param id L'identifiant du fournisseur à récupérer.
     * @return Le fournisseur correspondant à l'identifiant donné.
     */
    @GetMapping("/{id}")
    public Fournisseur getFournisseurById(@PathVariable Long id) {
        return fournisseurService.getFournisseurById(id);
    }

    /**
     * Méthode GET pour récupérer les produits fournis par un fournisseur spécifique.
     *
     * @param id L'identifiant du fournisseur.
     * @return La liste des produits fournis par le fournisseur.
     */
    @GetMapping("/{id}/produits")
    public List<ProduitSecurite> getProductsSuppliedBySupplier(@PathVariable Long id) {
        return fournisseurService.getProduitsFournisByFournisseurId(id);
    }

    /**
     * Méthode GET pour rechercher les fournisseurs par nom ou par adresse.
     *
     * @param nom     Le nom du fournisseur à rechercher (optionnel).
     * @param adresse L'adresse du fournisseur à rechercher (optionnel).
     * @return La liste des fournisseurs correspondant aux critères de recherche.
     */
    @GetMapping("/recherche")
    public List<Fournisseur> searchSuppliersByNameOrAddress(
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String adresse) {
        if (nom != null) {
            // Recherche les fournisseurs par nom
            return fournisseurService.getFournisseursByNom(nom);
        } else if (adresse != null) {
            // Recherche les fournisseurs par adresse
            return fournisseurService.getFournisseursByAdresse(adresse);
        } else {
            // Retourne tous les fournisseurs si aucun paramètre n'est spécifié
            return fournisseurService.getAllFournisseurs();
        }
    }
}