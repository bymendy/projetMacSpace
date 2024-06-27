package com.macsecurite.macsecurite.controller;
import lombok.Data;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Data
/**
 * Contrôleur pour gérer les stocks.
 */
public class StocksController {

    /**
     * Méthode GET pour afficher la gestion des stocks.
     *
     * @return Le nom de la vue Thymeleaf à afficher pour la gestion des stocks.
     */
    @GetMapping("/stocks")
    public String gestionDesStocks() {
        return "gestionDesStocks";
    }

    // Autres méthodes spécifiques à la gestion des stocks
}
