package com.macsecurite.macsecurite.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Représente les détails d'un contact, comprenant le nom, le prénom, l'email et le message.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {

    /**
     * Identifiant unique du contact.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto increment
    private int id;

    /**
     * Nom du contact.
     */
    @Column(name="nom")
    private String nom;

    /**
     * Prénom du contact.
     */
    @Column(name="prenom")
    private String prenom;

    /**
     * Adresse email du contact.
     */
    @Column(name="email")
    private String email;

    /**
     * Message envoyé par le contact.
     */
    @Column(name="message")
    private String message;

    /**
     * Renvoie les données du contact sous forme d'un tableau de chaînes de caractères.
     *
     * @return Un tableau contenant l'identifiant, le nom, le prénom, l'email et le message du contact.
     */
    public String[] getData(){
        return new String[]{""+this.id, this.nom, this.prenom, this.email, this.message.replaceAll("\n", "")};
    }
}
