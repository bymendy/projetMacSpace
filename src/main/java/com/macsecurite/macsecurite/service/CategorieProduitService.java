package com.macsecurite.macsecurite.service;

import com.macsecurite.macsecurite.model.CategorieProduit;
import com.macsecurite.macsecurite.repository.CategorieProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategorieProduitService {

    private final CategorieProduitRepository categorieProduitRepository;

    @Autowired
    public CategorieProduitService(CategorieProduitRepository categorieProduitRepository) {
        this.categorieProduitRepository = categorieProduitRepository;
    }

    public CategorieProduit saveCategorieProduit(CategorieProduit categorieProduit) {
        return categorieProduitRepository.save(categorieProduit);
    }

    public CategorieProduit getCategorieProduitById(Integer id) {
        return categorieProduitRepository.findById(id).orElse(null);
    }

    public List<CategorieProduit> getAllCategoriesProduit() {
        return categorieProduitRepository.findAll();
    }
}