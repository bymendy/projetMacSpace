package com.macsecurite.macsecurite.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Représente une commande passée par un client.
 */
@Entity
@Getter
@Setter
public class Commande {
    /**
     * Identifiant unique de la commande.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Date de la commande.
     */
    private Date dateCommande;

    /**
     * Statut de la commande.
     */
    private String statut;

    /**
     * Technicien associé à la commande.
     */
    @ManyToOne
    private Technicien technicien;

    /**
     * Liste des produits sécuritaires inclus dans la commande.
     */
    @ManyToMany
    private List<ProduitSecurite> produits;
}