package com.macsecurite.macsecurite.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Représente une intervention planifiée, comprenant des détails tels que le type, la date, la description, et les techniciens associés.
 */
@Entity
@Getter
@Setter
public class Intervention {

    /**
     * Identifiant unique de l'intervention.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIntervention;

    /**
     * Type de l'intervention.
     */
    private String type;

    /**
     * Date de l'intervention.
     */
    private Date date;

    /**
     * Description de l'intervention.
     */
    private String description;

    /**
     * Client associé à l'intervention.
     */
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    /**
     * Liste des tâches réalisées pour cette intervention.
     */
    @OneToMany(mappedBy = "intervention", cascade = CascadeType.ALL)
    private List<TacheRealiser> tachesRealiser;

    /**
     * Liste des techniciens associés à cette intervention.
     */
    @ManyToMany
    @JoinTable(
            name = "intervention_technicien",
            joinColumns = @JoinColumn(name = "id_intervention"),
            inverseJoinColumns = @JoinColumn(name = "id_technicien")
    )
    private List<Technicien> techniciens;

    /**
     * Liste des historiques d'intervention associés à cette intervention.
     */
    @OneToMany(mappedBy = "intervention", cascade = CascadeType.ALL)
    private List<HistoriqueIntervention> historiquesIntervention;

    /**
     * Constructeur par défaut.
     */
    public Intervention() {
    }

    /**
     * Constructeur avec tous les attributs.
     */
    public Intervention(String type, Date date, String description, Client client,
                        List<TacheRealiser> tachesRealiser, List<Technicien> techniciens,
                        List<HistoriqueIntervention> historiquesIntervention) {
        this.type = type;
        this.date = date;
        this.description = description;
        this.client = client;
        this.tachesRealiser = tachesRealiser;
        this.techniciens = techniciens;
        this.historiquesIntervention = historiquesIntervention;
    }
}