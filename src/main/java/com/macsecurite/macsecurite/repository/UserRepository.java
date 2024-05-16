package com.macsecurite.macsecurite.repository;

import com.macsecurite.macsecurite.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// L'annotation @Repository indique que cette classe est un composant Spring gérant l'accès aux données pour l'entité Users.
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    // Cette interface hérite de JpaRepository, qui fournit des méthodes CRUD prédéfinies pour l'entité Users.

    // Cette méthode permet de rechercher un utilisateur par son adresse email, ignorant la casse.
    Users findByEmailLikeIgnoreCase(String email);
}