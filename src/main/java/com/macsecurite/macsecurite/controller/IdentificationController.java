package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.dto.IdentificationDto;
import com.macsecurite.macsecurite.dto.UserDto;
import com.macsecurite.macsecurite.manager.Aleatoire;
import com.macsecurite.macsecurite.manager.JwtTokenManager;
import com.macsecurite.macsecurite.manager.WsException;
import com.macsecurite.macsecurite.model.Users;
import com.macsecurite.macsecurite.service.RoleService;
import com.macsecurite.macsecurite.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Data
@RestController
@RequestMapping("/api/open")
// @CrossOrigin(origins =  "http://localhost:3306")
public class IdentificationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Authentifie l'utilisateur en vérifiant son email et son mot de passe.
     * Retourne un token JWT si les informations sont valides.
     *
     * @param identificationDto les informations d'identification de l'utilisateur
     * @return une map contenant le token JWT
     * @throws WsException si l'email ou le mot de passe est incorrect
     */
    @PostMapping("/login")
    public Map<String, String> identification(@RequestBody IdentificationDto identificationDto) {
        String msgError = "L'email ou le mot de passe est incorrect";

        // Recherche l'utilisateur par email
        Users users = userService.findByEmail(identificationDto.getEmail());

        // Vérifie si l'email existe
        if (users == null) {
            // Lance une exception si l'email n'existe pas
            throw new WsException(HttpStatus.NOT_FOUND, msgError);
        }

        // Vérifie le mot de passe
        if (!this.bCryptPasswordEncoder.matches(identificationDto.getPassword(), users.getPassword())) {
            throw new WsException(HttpStatus.NOT_FOUND, msgError);
        }

        // Retourne un token JWT généré
        return Map.of("token", JwtTokenManager.generateToken(users.getToken()));
    }

    /**
     * Enregistre un nouvel utilisateur avec les informations fournies.
     * Retourne un token JWT après l'enregistrement.
     *
     * @param userDto les informations de l'utilisateur à enregistrer
     * @return une map contenant le token JWT
     * @throws WsException si les informations sont invalides (mot de passe trop court ou email déjà existant)
     */
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody UserDto userDto) {
        // Vérifie la longueur du mot de passe
        if (userDto.getPassword().length() <= 8) {
            throw new WsException(HttpStatus.BAD_REQUEST, "Le mot de passe doit contenir au moins 8 caractères");
        }

        // Vérifie si l'email existe déjà
        Users users = userService.findByEmail(userDto.getEmail());
        if (users != null) {
            throw new WsException(HttpStatus.BAD_REQUEST, "Cet email existe déjà");
        }

        // Crée un nouvel utilisateur avec les informations fournies
        users = userDto.getUser();
        users.setPassword(this.bCryptPasswordEncoder.encode(userDto.getPassword()));
        users.setRoles(List.of(roleService.save("USER")));

        // Génère un token pour l'utilisateur
        do {
            users.setToken(Aleatoire.getRandomStr(50));
        } while (userService.findBytoken(users.getToken()) != null);

        // Sauvegarde l'utilisateur dans la base de données
        userService.save(users);

        // Retourne un token JWT généré
        return Map.of("token", JwtTokenManager.generateToken(users.getToken()));
    }
}
