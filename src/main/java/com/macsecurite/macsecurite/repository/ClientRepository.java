package com.macsecurite.macsecurite.repository;

// Import de la classe Client du package model
import com.macsecurite.macsecurite.model.Client;

// Import de l'interface JpaRepository fournie par Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// Interface : En programmation, une interface définit un ensemble de méthodes
// (et éventuellement de constantes) qu'une classe doit implémenter.
// Elle fournit une spécification des fonctionnalités qu'une classe doit fournir.
//
//******
// Penses-y comme à une boîte de dialogue dans un jeu vidéo où tu choisis
// ce que ton personnage doit faire. Une interface, c'est comme un menu
// qui montre à un programme comment communiquer avec d'autres programmes.
//******
@Repository
// Déclaration de l'interface ClientRepository qui étend JpaRepository
public interface ClientRepository extends JpaRepository<Client, Long> {

    // Méthode supplémentaire :

    // Possible de définir des méthodes supplémentaires ici
    // Ces méthodes peuvent être des requêtes spécifiques à la récupération ou à la manipulation des données des clients
    // Spring Data JPA fournit des méthodes prédéfinies pour les opérations CRUD (Create, Read, Update, Delete)
    // Par exemple, findByNom(String nom) permet de récupérer un client par son nom
    // Les méthodes peuvent être nommées de manière explicite pour décrire l'opération qu'elles effectuent


}