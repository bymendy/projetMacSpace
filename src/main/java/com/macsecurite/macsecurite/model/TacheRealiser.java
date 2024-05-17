package com.macsecurite.macsecurite.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


/**
 * Représente une tâche réalisée dans le système.
 */
@Entity
// annotation indique que la classe TacheRealiser est une entité JPA,
// ce qui signifie qu'elle est mappée à une table dans la base de données.
@Getter
@Setter
public class TacheRealiser {
    // Identifiant de la tâche
    @Id //  indique que l'attribut idTache est la clé primaire de l'entité.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  indique que la valeur de l'attribut idTache sera générée automatiquement par la bdd
    // lors de l'insertion d'une nouvelle entité
    private Long idTache;

    // Description de la tâche
    private String description;

    // Relation many-to-one avec l'entité Intervention
    @ManyToOne // indique une relation many-to-one entre l'entité TacheRealiser et l'entité Intervention.
    // spécifie la colonne de jointure dans la table de la base de données pour mapper la relation many-to-one.
    @JoinColumn(name = "id_intervention")
    // attribut qui représente la relation many-to-one avec l'entité Intervention.
    private Intervention intervention;

    // Constructeur par défaut
    public TacheRealiser() {
    }
}