package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.CategorieProduit;
import com.macsecurite.macsecurite.repository.CategorieProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategorieProduitService {

    private final CategorieProduitRepository categorieProduitRepository;

    @Autowired
    public CategorieProduitService(CategorieProduitRepository categorieProduitRepository) {
        this.categorieProduitRepository = categorieProduitRepository;
    }

    // Sauvegarde une catégorie de produit
    public CategorieProduit saveCategorieProduit(CategorieProduit categorieProduit) {
        return categorieProduitRepository.save(categorieProduit);
    }

    // Récupère une catégorie de produit par son identifiant
    public CategorieProduit getCategorieProduitById(Long id) {
        return categorieProduitRepository.findById(id).orElse(null);
    }

    // Récupère toutes les catégories de produits
    public List<CategorieProduit> getAllCategoriesProduit() {
        return categorieProduitRepository.findAll();
    }

    // Autres méthodes spécifiques à la gestion des catégories de produit
}