package com.macsecurite.macsecurite.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Représente un produit de sécurité, tel que nom, quantité en stock, prix, catégorie et fournisseur associés.
 */
@Entity
@Getter
@Setter
public class ProduitSecurite {

    /**
     * Identifiant unique du produit de sécurité.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nom du produit de sécurité.
     */
    private String nom;

    /**
     * Quantité en stock du produit de sécurité.
     */
    private int quantiteStock;

    /**
     * Prix du produit de sécurité.
     */
    private double prix;

    /**
     * Catégorie à laquelle appartient le produit de sécurité.
     */
    @ManyToOne
    private CategorieProduit categorie;

    /**
     * Fournisseur du produit de sécurité.
     */
    @ManyToOne
    private Fournisseur fournisseur;

    /**
     * Liste des commandes contenant ce produit de sécurité.
     */
    @ManyToMany(mappedBy = "produits")
    private List<Commande> commandes;
}
