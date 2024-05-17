package com.macsecurite.macsecurite.repository;

import com.macsecurite.macsecurite.model.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Interface de repository responsable de l'accès aux données
 * pour l'entité Intervention dans la base de données.
 */
@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Long> {
    // Ajout des méthodes supplémentaires si nécessaire
}