package com.macsecurite.macsecurite.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
/**
 * Représente une catégorie de produit.
 */
public class CategorieProduit {
    /**
     * Identifiant de la catégorie de produit.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nom de la catégorie de produit.
     */
    private String nom;

    /**
     * Description de la catégorie de produit.
     */
    private String description;

    /**
     * Liste des produits associés à cette catégorie.
     */
    @OneToMany(mappedBy = "categorie")
    private List<ProduitSecurite> produits;
}