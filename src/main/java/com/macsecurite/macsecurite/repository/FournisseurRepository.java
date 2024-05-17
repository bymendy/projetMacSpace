package com.macsecurite.macsecurite.repository;

import com.macsecurite.macsecurite.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Interface de repository responsable de l'accès aux données pour l'entité Fournisseur dans la base de données.
 */
@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    /**
     * Méthode pour rechercher les fournisseurs par leur nom.
     * @param nom Le nom du fournisseur à rechercher.
     * @return Une liste de fournisseurs correspondant au nom spécifié.
     */
    List<Fournisseur> findByNom(String nom);

    /**
     * Méthode pour rechercher les fournisseurs par leur adresse.
     * @param adresse L'adresse du fournisseur à rechercher.
     * @return Une liste de fournisseurs correspondant à l'adresse spécifiée.
     */
    List<Fournisseur> findByAdresse(String adresse);
}