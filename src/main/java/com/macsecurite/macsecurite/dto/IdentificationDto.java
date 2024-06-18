package com.macsecurite.macsecurite.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class IdentificationDto {
    /**
     * L'email de l'utilisateur.
     */
    private String email;

    /**
     * Le mot de passe de l'utilisateur.
     */
    private String password;

}
