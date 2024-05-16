package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.Fournisseur;
import com.macsecurite.macsecurite.model.ProduitSecurite;
import com.macsecurite.macsecurite.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {

    private final FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurService(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    // Sauvegarde un fournisseur dans la base de données
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    // Récupère un fournisseur par son identifiant
    public Fournisseur getFournisseurById(Long id) {
        return fournisseurRepository.findById(id).orElse(null);
    }

    // Récupère tous les fournisseurs de la base de données
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    // Récupère les produits fournis par un fournisseur spécifique
    public List<ProduitSecurite> getProduitsFournisByFournisseurId(Long id) {
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

    // Récupère les fournisseurs par leur nom
    public List<Fournisseur> getFournisseursByNom(String nom) {
        return fournisseurRepository.findByNom(nom);
    }

    // Récupère les fournisseurs par leur adresse
    public List<Fournisseur> getFournisseursByAdresse(String adresse) {
        return fournisseurRepository.findByAdresse(adresse);
    }


}