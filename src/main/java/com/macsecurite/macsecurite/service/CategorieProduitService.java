package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.CategorieProduit;
import com.macsecurite.macsecurite.repository.CategorieProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Cette classe gère la logique métier associée aux catégories de produits.
 */
@Service
public class CategorieProduitService {

    private final CategorieProduitRepository categorieProduitRepository;

    /**
     * Constructeur de la classe CategorieProduitService.
     *
     * @param categorieProduitRepository Le repository des catégories de produits
     */
    @Autowired
    public CategorieProduitService(CategorieProduitRepository categorieProduitRepository) {
        this.categorieProduitRepository = categorieProduitRepository;
    }

    /**
     * Sauvegarde une catégorie de produit.
     *
     * @param categorieProduit La catégorie de produit à sauvegarder
     * @return La catégorie de produit sauvegardée
     */
    public CategorieProduit saveCategorieProduit(CategorieProduit categorieProduit) {
        return categorieProduitRepository.save(categorieProduit);
    }

    /**
     * Récupère une catégorie de produit par son identifiant.
     *
     * @param id L'identifiant de la catégorie de produit à récupérer
     * @return La catégorie de produit trouvée, ou null si aucune catégorie correspondante n'est trouvée
     */
    public CategorieProduit getCategorieProduitById(Long id) {
        return categorieProduitRepository.findById(id).orElse(null);
    }

    /**
     * Récupère toutes les catégories de produits.
     *
     * @return La liste de toutes les catégories de produits
     */
    public List<CategorieProduit> getAllCategoriesProduit() {
        return categorieProduitRepository.findAll();
    }

    // Autres méthodes spécifiques à la gestion des catégories de produit
}