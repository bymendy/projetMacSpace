package com.macsecurite.macsecurite.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

/**
 * Représente un rôle utilisateur dans le système.
 */
@Entity // Indique que cette classe est une entité JPA
@Table(name = "role") // Spécifie le nom de la table dans la base de données
@Data // Génère automatiquement les méthodes toString(), equals(), hashCode(), et les méthodes getters et setters
public class Role implements GrantedAuthority { // Implémente l'interface GrantedAuthority de Spring Security

    /**
     * Identifiant unique du rôle.
     */
    @Id // Indique que ce champ est la clé primaire de l'entité
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY) // Spécifie la stratégie de génération automatique de la valeur de la clé primaire
    private Integer id; // Champ représentant l'identifiant unique du rôle

    /**
     * Nom du rôle.
     */
    private String name; //

    /**
     * Implémente la méthode de l'interface GrantedAuthority pour retourner le nom du rôle.
     * @return Le nom du rôle
     */
    @Override
    public String getAuthority() { //
        return this.name; //
    }
}