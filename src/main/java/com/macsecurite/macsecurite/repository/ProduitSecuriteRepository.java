package com.macsecurite.macsecurite.repository;

import com.macsecurite.macsecurite.model.ProduitSecurite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Ce repository est responsable de l'accès aux données pour l'entité ProduitSecurite dans la base de données.
 */
@Repository
// Ce repository est responsable de l'accès aux données pour l'entité ProduitSecurite dans la bdd.
public interface ProduitSecuriteRepository extends JpaRepository<ProduitSecurite, Integer> {
    // Ajout des méthodes supplémentaires si nécessaire
}