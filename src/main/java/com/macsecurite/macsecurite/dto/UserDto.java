package com.macsecurite.macsecurite.dto;

import com.macsecurite.macsecurite.model.Users;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class UserDto {

    /**
     * Le nom de l'utilisateur.
     */
    private String name;

    /**
     * Le prenom de l'utilisateur.
     */
    private String prenom;
    /**
     * L'email de l'utilisateur.
     */
    private String email;

    /**
     * Le mot de passe de l'utilisateur.
     */
    private String password;

    /**
     * Convertit l'objet UserDto en objet Users.
     *
     * @return un objet Users avec les informations de l'utilisateur.
     */
    public Users getUser(){
        Users users = new Users();
        users.setName(this.name);
        users.setPrenom(this.prenom);
        users.setEmail(this.email);
        users.setPassword(this.password);
        users.setDateCreation(new Date());
        return users;
    }

}
