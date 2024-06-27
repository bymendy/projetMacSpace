package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.Fournisseur;
import com.macsecurite.macsecurite.model.ProduitSecurite;
import com.macsecurite.macsecurite.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Le service FournisseurService gère les opérations métier liées aux fournisseurs.
 */
@Service
public class FournisseurService {

    private  FournisseurRepository fournisseurRepository;

    ///**
    // * Constructeur du service FournisseurService.
    //*
    //* @param fournisseurRepository Le repository utilisé pour accéder aux données des fournisseurs dans la base de données.
    //*/
    //@Autowired
    //public FournisseurService(FournisseurRepository fournisseurRepository) {
    //this.fournisseurRepository = fournisseurRepository;
    //}

    /**
     * Sauvegarde un fournisseur dans la base de données.
     *
     * @param fournisseur Le fournisseur à sauvegarder.
     * @return Le fournisseur sauvegardé.
     */
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    /**
     * Récupère un fournisseur par son identifiant.
     *
     * @param id L'identifiant du fournisseur à récupérer.
     * @return Le fournisseur trouvé ou null s'il n'existe pas.
     */
    public Fournisseur getFournisseurById(Integer id) {
        return fournisseurRepository.findById(id).orElse(null);
    }

    /**
     * Récupère tous les fournisseurs de la base de données.
     *
     * @return La liste de tous les fournisseurs.
     */
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    /**
     * Récupère les produits fournis par un fournisseur spécifique.
     *
     * @param id L'identifiant du fournisseur.
     * @return La liste des produits fournis par le fournisseur ou null s'il n'existe pas.
     */
    public List<ProduitSecurite> getProduitsFournisByFournisseurId(Integer id) {
        // Recherche le fournisseur dans la base de données par son identifiant
        Fournisseur fournisseur = fournisseurRepository.findById(id).orElse(null);

        // Vérifie si le fournisseur existe
        if (fournisseur != null) {
            // Retourne la liste des produits fournis par le fournisseur directement
            return fournisseur.getProduits();
        } else {
            // Retourne null si le fournisseur n'est pas trouvé
            return null;
        }
    }

    /**
     * Récupère les fournisseurs par leur nom.
     *
     * @param nom Le nom des fournisseurs à récupérer.
     * @return La liste des fournisseurs correspondant au nom spécifié.
     */
    public List<Fournisseur> getFournisseursByNom(String nom) {
        return fournisseurRepository.findByNom(nom);
    }

    /**
     * Récupère les fournisseurs par leur adresse.
     *
     * @param adresse L'adresse des fournisseurs à récupérer.
     * @return La liste des fournisseurs correspondant à l'adresse spécifiée.
     */
    public List<Fournisseur> getFournisseursByAdresse(String adresse) {
        return fournisseurRepository.findByAdresse(adresse);
    }
}