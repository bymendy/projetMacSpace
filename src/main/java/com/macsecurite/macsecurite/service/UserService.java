package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.Users;
import com.macsecurite.macsecurite.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.SignatureException;

/**
 * Le service UserService est responsable de la gestion des utilisateurs et fournit des services métier associés.
 */
@Service
public class UserService implements UserDetailsService {

    // Injection de dépendance : associe cette classe à un repository pour accéder aux données des utilisateurs.
    @Autowired // New UserRepository
    private UserRepository userRepository;

    /**
     * Enregistre un utilisateur dans la base de données.
     *
     * @param users l'utilisateur à enregistrer
     * @return l'utilisateur enregistré
     */
    public Users save(Users users) {
        // Sauvegarde l'utilisateur dans la base de données
        return userRepository.save(users);
    }

    /**
     * Recherche un utilisateur par son adresse email.
     *
     * @param email L'adresse email de l'utilisateur à rechercher.
     * @return L'utilisateur correspondant à l'adresse email spécifiée.
     */
    public Users findByEmail(String email) {
        return userRepository.findByEmailLikeIgnoreCase(email);
    }

    public Users findBytoken(String token){
        return userRepository.findByToken(token) ;
    }


    public Users saveUser(Users user){
        return userRepository.save(user);
    }


    /**
     * Vérifie si un token existe déjà dans la base de données.
     *
     * @param token le token à vérifier
     * @return true si le token existe, false sinon
     */
    public boolean isTokenExiste(String token) {
        return userRepository.findByToken(token) != null;
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
        UserDetails user = userRepository.findByEmailLikeIgnoreCase(username);
        // Si l'utilisateur n'est pas trouvé, une exception est levée.
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        // Sinon, retourne l'utilisateur trouvé.
        return user;
    }



    private static final String SECRET_KEY = "your_secret_key"; // Replace with your actual secret key



}