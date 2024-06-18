package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.Role;
import com.macsecurite.macsecurite.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* Service pour gérer les rôles des utilisateurs.
 * Fournit des méthodes pour sauvegarder et récupérer les rôles.
 */
@Service
public class RoleService  {

    /**
     * Énumération des rôles disponibles.
     */
    public enum ROLE{
        CLIENT("CLIENT"),
        ADMIN("ADMIN"),
        MANAGER("MANAGER");

        String value;
        ROLE(String value){
            this.value = value;
        }
    }


    @Autowired
    private RoleRepository roleRepository;

    /**
     * Sauvegarde un rôle dans le repository. Si le rôle existe déjà, il est retourné sans être sauvegardé à nouveau.
     *
     * @param role le rôle à sauvegarder
     * @return le rôle sauvegardé ou le rôle existant
     */
    public Role saveRole(Role role) {
        // Cherche le rôle par son nom en ignorant la casse
        Role findRole = roleRepository.findByNameLikeIgnoreCase(role.getName());
        if (findRole != null) {
            // Retourne le rôle existant si trouvé
            return findRole;
        }
        // Sauvegarde et retourne le nouveau rôle
        return roleRepository.save(role);
    }

    /**
     * Récupère un rôle par son nom. Si le rôle n'existe pas, il est créé et sauvegardé dans le repository.
     *
     * @param role le rôle à récupérer
     * @return le rôle existant ou le nouveau rôle créé
     */
    public Role getRole(ROLE role) {
        // Cherche le rôle par son nom en ignorant la casse
        Role findRole = roleRepository.findByNameLikeIgnoreCase(role.value);
        if (findRole != null) {
            // Retourne le rôle existant si trouvé
            return findRole;
        }
        // Crée un nouveau rôle si non trouvé
        findRole = new Role();
        findRole.setName(role.value);
        // Sauvegarde et retourne le nouveau rôle
        return roleRepository.save(findRole);
    }
    /**
     *
     * Sauvegarde un rôle dans le repository. Si le rôle existe déjà, il est retourné sans être sauvegardé à nouveau.
     *
     * @param roleName le nom du rôle à sauvegarder
     * @return le rôle sauvegardé ou le rôle existant
     */
    public Role save(String roleName) {
        // Crée un nouveau rôle avec le nom donné
        Role role = new Role();
        role.setName(roleName);
        // Sauvegarde le rôle en utilisant la méthode saveRole existante
        return saveRole(role);
    }
}