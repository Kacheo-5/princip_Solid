package services;

import entity.Article;

public class DefaultTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(Article article) {
        return 0; // Pas de taxe par défaut
    }

    @Override
    public boolean supports(String category) {
        return true; // Supporte toutes les catégories par défaut
    }
}
