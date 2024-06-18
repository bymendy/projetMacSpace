package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.model.Users;
import com.macsecurite.macsecurite.service.UserService;
import com.macsecurite.macsecurite.dto.UserDto;
import com.macsecurite.macsecurite.exception.ApiException;
import com.macsecurite.macsecurite.manager.Aleatoire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Récupère la liste des projets pour l'utilisateur connecté.
     *
     * @param userConnecter les détails de l'utilisateur connecté
     * @return une liste de projets
     */
    @GetMapping("/client/")
    public List<String> getProjets(@AuthenticationPrincipal UserDetails userConnecter) {
        return List.of("java", "c#", "php", userConnecter.getUsername());
    }

    /**
     * Authentifie l'utilisateur et génère un token si l'authentification réussit.
     *
     * @param userDto les informations de connexion de l'utilisateur
     * @return un Map contenant le token d'authentification
     * @throws ApiException si l'email ou le mot de passe est invalide
     */
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UserDto userDto) throws ApiException {
        Users users = userService.findByEmail(userDto.getEmail());
        if  (users == null ) {
            bCryptPasswordEncoder.matches(userDto.getPassword(), "admin");
            throw new ApiException();
        }
        if (!bCryptPasswordEncoder.matches(userDto.getPassword(), users.getPassword())) {
            throw new ApiException();
        }

        String token;
        do {
            token = Aleatoire.getRandomStr(200);
        } while (userService.isTokenExiste(token));

        users.setToken(token);
        userService.saveUser(users); // sauvegarder le token

        return Map.of("token", token);
    }

}