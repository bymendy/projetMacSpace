package com.macsecurite.macsecurite.controller;

import com.macsecurite.macsecurite.model.Technicien;
import com.macsecurite.macsecurite.service.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/techniciens")
/**
 * Contrôleur pour gérer les techniciens.
 */
public class TechnicienController {

    private final TechnicienService technicienService;

    /**
     * Injection du service TechnicienService via le constructeur.
     *
     * @param technicienService Le service TechnicienService à injecter.
     */
    @Autowired
    public TechnicienController(TechnicienService technicienService) {
        this.technicienService = technicienService;
    }

    /**
     * Méthode POST pour créer un technicien.
     *
     * @param technicien Le technicien à créer.
     * @return Le technicien créé.
     */
    @PostMapping("/")
    public Technicien createTechnicien(@RequestBody Technicien technicien) {
        return technicienService.saveTechnicien(technicien);
    }

    /**
     * Méthode GET pour récupérer tous les techniciens.
     *
     * @return La liste de tous les techniciens.
     */
    @GetMapping("/")
    public List<Technicien> getAllTechniciens() {
        return technicienService.getAllTechniciens();
    }

    /**
     * Méthode GET pour récupérer un technicien par son identifiant.
     *
     * @param id L'identifiant du technicien à récupérer.
     * @return Le technicien correspondant à l'identifiant.
     */
    @GetMapping("/{id}")
    public Technicien getTechnicienById(@PathVariable Long id) {
        return technicienService.getTechnicienById(id);
    }
}