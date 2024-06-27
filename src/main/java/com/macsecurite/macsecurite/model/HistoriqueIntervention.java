package com.macsecurite.macsecurite.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Représente l'historique d'une intervention effectuée, contenant les détails de l'intervention, ainsi que sa date et son heure.
 */
@Entity
@Getter
@Setter
public class HistoriqueIntervention {

    /**
     * Identifiant unique de l'historique de l'intervention.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistorique;

    /**
     * Intervention associée à cet historique.
     */
    @ManyToOne
    @JoinColumn(name = "id_intervention")
    private Intervention intervention;

    /**
     * Détails de l'intervention.
     */
    private String detailsIntervention;

    /**
     * Date et heure de l'intervention.
     */
    private Date dateHeureIntervention;

    /**
     * Constructeur par défaut.
     */
    public HistoriqueIntervention() {
    }
}