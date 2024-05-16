package com.macsecurite.macsecurite.repository;

import com.macsecurite.macsecurite.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    // Méthode pour rechercher les fournisseurs par leur nom
    List<Fournisseur> findByNom(String nom);

    // Méthode pour rechercher les fournisseurs par leur adresse
    List<Fournisseur> findByAdresse(String adresse);
}