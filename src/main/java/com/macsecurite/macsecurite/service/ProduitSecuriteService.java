package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.ProduitSecurite;
import com.macsecurite.macsecurite.repository.ProduitSecuriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Le service ProduitSecuriteService gère les opérations métier liées aux produits de sécurité.
 */
@Service
public class ProduitSecuriteService {

    private final ProduitSecuriteRepository produitSecuriteRepository;

    /**
     * Constructeur du service ProduitSecuriteService.
     *
     * @param produitSecuriteRepository Le repository utilisé pour accéder aux données des produits de sécurité dans la base de données.
     */
    @Autowired
    public ProduitSecuriteService(ProduitSecuriteRepository produitSecuriteRepository) {
        this.produitSecuriteRepository = produitSecuriteRepository;
    }

    /**
     * Enregistre un produit de sécurité dans la base de données.
     *
     * @param produitSecurite Le produit de sécurité à enregistrer.
     * @return Le produit de sécurité enregistré.
     */
    public ProduitSecurite saveProduitSecurite(ProduitSecurite produitSecurite) {
        return produitSecuriteRepository.save(produitSecurite);
    }

    /**
     * Récupère un produit de sécurité à partir de son identifiant.
     *
     * @param id L'identifiant du produit de sécurité à récupérer.
     * @return Le produit de sécurité correspondant à l'identifiant, ou null s'il n'est pas trouvé.
     */
    public ProduitSecurite getProduitSecuriteById(Long id) {
        return produitSecuriteRepository.findById(id).orElse(null);
    }

    /**
     * Récupère tous les produits de sécurité enregistrés dans la base de données.
     *
     * @return La liste de tous les produits de sécurité.
     */
    public List<ProduitSecurite> getAllProduitsSecurite() {
        return produitSecuriteRepository.findAll();
    }

    // Autres méthodes spécifiques à la gestion des produits de sécurité
}