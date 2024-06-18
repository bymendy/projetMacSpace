package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.dto.IdentificationDto;
import com.macsecurite.macsecurite.dto.UserDto;
import com.macsecurite.macsecurite.manager.JwtTokenManager;
import com.macsecurite.macsecurite.manager.WsException;
import com.macsecurite.macsecurite.model.Users;
import com.macsecurite.macsecurite.service.RoleService;
import com.macsecurite.macsecurite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/open")
public class IdentificationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    /**
     * La methode elle permet de récupérer l'email et le mdp de l'utilisateur
     * @return
     * <ul>
     *     <li><b>Exception</b> si l'email ou mdp n'existe pas</li>
     *     <li><b>token</b> si l'email ou mdp existe </li>
     * </ul>
     */
    @PostMapping("/identification")
    public Map<String, String> identification(@RequestBody IdentificationDto identificationDto) {


        String msgError = "L'email ou le mot de passe est incorrect";
        // Recherche l'utilisateur par email
        Users users = userService.findByEmail(identificationDto.getEmail());
        // Vérifie si l'email existe
        if (users == null) {
            // Lance une exception si l'email n'existe pas
            throw new WsException(HttpStatus.NOT_FOUND, msgError);
        }
        // Vérifie le mot de passe (commenté pour l'instant, à décommenter si nécessaire)
         if (!this.bCryptPasswordEncoder.matches(identificationDto.getPassword(), users.getPassword())) {
            throw new WsException(HttpStatus.NOT_FOUND, msgError);
        }

        // Retourne une confirmation d'identification
        return Map.of("token", JwtTokenManager.generateToken(users.getToken()));
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody UserDto userDto) {
        if (userDto.getPassword().length() <= 8){
            throw new WsException(HttpStatus.BAD_REQUEST, "Le mot de passe dpit contenir au moins 8 caractéres");
        }

        Users users = userService.findByEmail(userDto.getEmail());
        if (users != null) {
            throw new WsException(HttpStatus.BAD_REQUEST, "Cet email existe déjà");
        }
        users = userDto.getUser();
        users.setPassword(this.bCryptPasswordEncoder.encode(userDto.getPassword()));
        users.setRoles(List.of(roleService.save("USER")));
        userService.save(users);

        // Retourne une confirmation d'identification
        return Map.of("token", JwtTokenManager.generateToken(users.getToken()));

    }

}
