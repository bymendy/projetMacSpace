package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.Users;
import com.macsecurite.macsecurite.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Le service UserService est responsable de la gestion des utilisateurs et fournit des services métier associés.
 */
@Service
public class UserService implements UserDetailsService {

    // Injection de dépendance : associe cette classe à un repository pour accéder aux données des utilisateurs.
    @Autowired
    private UserRepository userRepository;

    /**
     * Recherche un utilisateur par son adresse email.
     *
     * @param email L'adresse email de l'utilisateur à rechercher.
     * @return L'utilisateur correspondant à l'adresse email spécifiée.
     */
    public Users findByEmail(String email) {
        return userRepository.findByEmailLikeIgnoreCase(email);
    }

    /**
     * Implémentation de la méthode d'UserDetailsService pour charger un utilisateur par son nom d'utilisateur.
     *
     * @param username Le nom d'utilisateur (adresse email) de l'utilisateur à charger.
     * @return Les détails de l'utilisateur chargé.
     * @throws UsernameNotFoundException Si aucun utilisateur correspondant au nom d'utilisateur spécifié n'est trouvé.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Recherche de l'utilisateur dans le repository par son email (qui est utilisé comme nom d'utilisateur).
        Users user = userRepository.findByEmailLikeIgnoreCase(username);
        // Si l'utilisateur n'est pas trouvé, une exception est levée.
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        // Sinon, retourne l'utilisateur trouvé.
        return user;
    }
}