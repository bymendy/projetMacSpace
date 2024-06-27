package com.macsecurite.macsecurite.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Représente un fournisseur de produits de sécurité, caractérisé par son nom, son adresse et ses contacts.
 */
@Entity
@Getter
@Setter
public class Fournisseur {

    /**
     * Identifiant unique du fournisseur.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nom du fournisseur.
     */
    private String nom;

    /**
     * Adresse du fournisseur.
     */
    private String adresse;

    /**
     * Contact du fournisseur.
     */
    private String contact;

    /**
     * Liste des produits de sécurité fournis par ce fournisseur.
     */
    @OneToMany(mappedBy = "fournisseur")
    private List<ProduitSecurite> produits;
}