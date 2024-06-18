package com.macsecurite.macsecurite.repository;

import com.macsecurite.macsecurite.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * L'annotation @Repository indique que cette classe est un composant Spring gérant l'accès aux données pour l'entité Users.
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    /**
     * Cette méthode permet de rechercher un utilisateur par son adresse email, ignorant la casse.
     *
     * @param email L'adresse email de l'utilisateur à rechercher
     * @return L'utilisateur trouvé, ou null s'il n'existe pas
     */
    Users findByEmailLikeIgnoreCase(String email);

    /**
     * Trouve un utilisateur par son token.
     *
     * @param token le token à rechercher
     * @return l'utilisateur correspondant ou null si aucun utilisateur n'est trouvé
     */
    Users findByToken(String token);
}