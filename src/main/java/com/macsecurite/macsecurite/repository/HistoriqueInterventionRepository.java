package com.macsecurite.macsecurite.repository;

import com.macsecurite.macsecurite.model.HistoriqueIntervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueInterventionRepository extends JpaRepository<HistoriqueIntervention, Long> {
    // Ajout des méthodes supplémentaires si nécessaire
}
