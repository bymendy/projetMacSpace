package com.macsecurite.macsecurite.repository;

import com.macsecurite.macsecurite.model.CategorieProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interface de repository responsable de l'accès aux données pour l'entité CategorieProduit dans la base de données.
 */
@Repository
public interface CategorieProduitRepository extends JpaRepository<CategorieProduit, Long> {
    // Ajout des méthodes supplémentaires si nécessaire
}