package com.macsecurite.macsecurite.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto increment
    private int id;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="email")
    private String email;

    @Column(name="message")
    private String message;


    /**
     * Methode qui permet de me retourner les données de ma classe sous forme d'un tableau
     * @return
     */
    public String[] getData(){

        return new String[]{""+this.id, this.nom, this.prenom, this.email, this.message.replaceAll("\n", "")};
    }

}
