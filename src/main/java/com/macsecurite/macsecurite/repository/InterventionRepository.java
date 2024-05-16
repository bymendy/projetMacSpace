package com.macsecurite.macsecurite.repository;

import com.macsecurite.macsecurite.model.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// indique à Spring que cette interface est une interface de dépôt,
// ce qui signifie qu'elle gère l'accès aux données pour l'entité Intervention.
@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Long> {
    // Ajout des méthodes supplémentaires si nécessaire
}