package com.macsecurite.macsecurite.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    /**
     * L'email de l'utilisateur.
     */
    private String email;

    /**
     * Le mot de passe de l'utilisateur.
     */
    private String password;

    // Les annotations @Getter et @Setter de Lombok génèrent automatiquement les méthodes getEmail, setEmail, getPassword et setPassword.

}
