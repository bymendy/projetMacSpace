package com.macsecurite.macsecurite.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Représente un technicien dans le système.
 */
@Entity
@Getter
@Setter
public class Technicien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTechnicien;

    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String competences;

    // Relation One-to-Many avec Commande
    @OneToMany(mappedBy = "technicien")
    private List<Commande> commandes;

    // Constructeur par défaut
    public Technicien() {
    }
}