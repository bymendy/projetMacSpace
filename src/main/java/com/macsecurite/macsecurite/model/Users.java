package com.macsecurite.macsecurite.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * L'entité Users représente un utilisateur dans le système.
 */
@Entity
@Table(name = "users")
@Data // Génère automatiquement les méthodes toString(), equals(), hashCode(), et les méthodes getters et setters
public class Users implements UserDetails { // Implémente l'interface UserDetails de Spring Security pour représenter un utilisateur

    @Id // Indique que ce champ est la clé primaire de l'entité
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY) // Spécifie la stratégie de génération automatique de la valeur de la clé primaire
    private Integer id; // Champ représentant l'identifiant unique de l'utilisateur

    private String name; // Champ représentant le nom de l'utilisateur
    private String email; // Champ représentant l'email de l'utilisateur
    private String password; // Champ représentant le mot de passe de l'utilisateur
    private boolean active; // Champ représentant l'état d'activation de l'utilisateur

    @ManyToMany(fetch = FetchType.EAGER) // Indique une relation Many-to-Many entre Users et Role
    private List<Role> roles; // Champ représentant les rôles associés à l'utilisateur

    /**
     * Récupère les autorités accordées à l'utilisateur.
     *
     * @return Une collection contenant les autorités de l'utilisateur.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // Implémente la méthode de l'interface UserDetails pour récupérer les autorités accordées à l'utilisateur
        return this.roles; // Retourne les rôles associés à l'utilisateur
    }

    /**
     * Récupère le nom d'utilisateur de l'utilisateur (son email).
     *
     * @return Le nom d'utilisateur de l'utilisateur.
     */
    @Override
    public String getUsername() { // Implémente la méthode de l'interface UserDetails pour récupérer le nom d'utilisateur (email)
        return this.email; // Retourne l'email de l'utilisateur comme nom d'utilisateur
    }

    /**
     * Vérifie si le compte de l'utilisateur est expiré.
     *
     * @return true si le compte de l'utilisateur n'est pas expiré, sinon false.
     */
    @Override
    public boolean isAccountNonExpired() { // Implémente la méthode de l'interface UserDetails pour vérifier si le compte de l'utilisateur n'a pas expiré
        return this.active; // Retourne l'état d'activation de l'utilisateur
    }

    /**
     * Vérifie si le compte de l'utilisateur n'est pas verrouillé.
     *
     * @return true si le compte de l'utilisateur n'est pas verrouillé, sinon false.
     */
    @Override
    public boolean isAccountNonLocked() { // Implémente la méthode de l'interface UserDetails pour vérifier si le compte de l'utilisateur n'est pas verrouillé
        return this.active;
    }

    /**
     * Vérifie si les informations d'identification de l'utilisateur ne sont pas expirées.
     *
     * @return true si les informations d'identification de l'utilisateur ne sont pas expirées, sinon false.
     */
    @Override
    public boolean isCredentialsNonExpired() { // Implémente la méthode de l'interface UserDetails pour vérifier si les informations d'identification de l'utilisateur n'ont pas expiré
        return this.active;
    }

    /**
     * Vérifie si le compte de l'utilisateur est activé.
     *
     * @return true si le compte de l'utilisateur est activé, sinon false.
     */
    @Override
    public boolean isEnabled() { // Implémente la méthode de l'interface UserDetails pour vérifier si le compte de l'utilisateur est activé
        return this.active;
    }
}
