package com.macsecurite.macsecurite.repository;

import com.macsecurite.macsecurite.model.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Ce repository est responsable de l'accès aux données pour l'entité Technicien dans la base de données.
 */
@Repository
// Ce repository est responsable de l'accès aux données pour l'entité Technicien dans la base de données.
public interface TechnicienRepository extends JpaRepository<Technicien, Integer> {
    // Ajout des méthodes supplémentaires si nécessaire
}