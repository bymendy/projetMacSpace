package com.macsecurite.macsecurite.repository;

import com.macsecurite.macsecurite.model.HistoriqueIntervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de repository responsable de l'accès aux données pour l'entité HistoriqueIntervention dans la base de données.
 */
@Repository
public interface HistoriqueInterventionRepository extends JpaRepository<HistoriqueIntervention, Integer> {
    // Ajout des méthodes supplémentaires si nécessaire
}
