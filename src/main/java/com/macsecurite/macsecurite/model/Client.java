package com.macsecurite.macsecurite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
/**
 * Représente un client de l'entreprise.
 */
@Entity // Définition de l'entité Client
@Getter
@Setter
// Génèrent automatiquement les méthodes getters
// et setters pour les champs de la classe.
public class Client {
    /**
     * Identifiant unique du client.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nom du client.
     */
    private String nom;

    /**
     * Prénom du client.
     */
    private String prenom;

    /**
     * Adresse du client.
     */
    private String adresse;

    /**
     * Numéro de téléphone du client.
     */
    private String numeroTelephone;

    /**
     * Constructeur par défaut.
     */
    public Client() {
    }

    /**
     * Constructeur avec des paramètres pour initialiser les attributs.
     * @param nom Nom du client.
     * @param prenom Prénom du client.
     * @param adresse Adresse du client.
     * @param numeroTelephone Numéro de téléphone du client.
     */
    public Client(String nom, String prenom, String adresse, String numeroTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numeroTelephone = numeroTelephone;
    }

    // Autres méthodes de la classe Client
}
