package com.macsecurite.macsecurite.repository;

import com.macsecurite.macsecurite.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Ce repository est responsable de l'accès aux données pour l'entité Commande dans la base de données.
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    // Ajout des méthodes supplémentaires si nécessaire
}