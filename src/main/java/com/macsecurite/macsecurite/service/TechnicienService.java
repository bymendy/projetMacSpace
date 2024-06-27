package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.Technicien;
import com.macsecurite.macsecurite.repository.TechnicienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Le service TechnicienService gère les opérations métier liées aux techniciens.
 */
@Service
public class TechnicienService {

    private  TechnicienRepository technicienRepository;

    ///**
    //* Constructeur du service TechnicienService.
    //*
    //* @param technicienRepository Le repository utilisé pour accéder aux données des techniciens dans la base de données.
    //*/
    //@Autowired
    //public TechnicienService(TechnicienRepository technicienRepository) {
    //this.technicienRepository = technicienRepository;
    //}

    /**
     * Enregistre un technicien dans la base de données.
     *
     * @param technicien Le technicien à enregistrer.
     * @return Le technicien enregistré.
     */
    public Technicien saveTechnicien(Technicien technicien) {
        return technicienRepository.save(technicien);
    }

    /**
     * Récupère un technicien à partir de son identifiant.
     *
     * @param id L'identifiant du technicien à récupérer.
     * @return Le technicien correspondant à l'identifiant, ou null s'il n'est pas trouvé.
     */
    public Technicien getTechnicienById(Integer id) {
        return technicienRepository.findById(id).orElse(null);
    }

    /**
     * Récupère tous les techniciens enregistrés dans la base de données.
     *
     * @return La liste de tous les techniciens.
     */
    public List<Technicien> getAllTechniciens() {
        return technicienRepository.findAll();
    }

    // Autres méthodes spécifiques à la gestion des techniciens
}