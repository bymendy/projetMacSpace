package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.Technicien;
import com.macsecurite.macsecurite.repository.TechnicienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicienService {

    private final TechnicienRepository technicienRepository;

    @Autowired
    public TechnicienService(TechnicienRepository technicienRepository) {
        this.technicienRepository = technicienRepository;
    }

    // Sauvegarde un technicien dans la base de données
    public Technicien saveTechnicien(Technicien technicien) {
        return technicienRepository.save(technicien);
    }

    // Récupère un technicien par son identifiant
    public Technicien getTechnicienById(Long id) {
        return technicienRepository.findById(id).orElse(null);
    }

    // Récupère tous les techniciens de la base de données
    public List<Technicien> getAllTechniciens() {
        return technicienRepository.findAll();
    }

    // Autres méthodes spécifiques à la gestion des techniciens
}