package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.ProduitSecurite;
import com.macsecurite.macsecurite.repository.ProduitSecuriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitSecuriteService {

    private final ProduitSecuriteRepository produitSecuriteRepository;

    @Autowired
    public ProduitSecuriteService(ProduitSecuriteRepository produitSecuriteRepository) {
        this.produitSecuriteRepository = produitSecuriteRepository;
    }

    // Méthodes pour gérer les opérations liées aux produits de sécurité

    public ProduitSecurite saveProduitSecurite(ProduitSecurite produitSecurite) {
        return produitSecuriteRepository.save(produitSecurite);
    }

    public ProduitSecurite getProduitSecuriteById(Long id) {
        return produitSecuriteRepository.findById(id).orElse(null);
    }

    public List<ProduitSecurite> getAllProduitsSecurite() {
        return produitSecuriteRepository.findAll();
    }

    // Autres méthodes spécifiques à la gestion des produits de sécurité
}