package services;

import entity.Article;

public class ElectronicsTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(Article article) {
        return article.getPrice() * 0.2; // Taxe spéciale pour l'électronique
    }

    @Override
    public boolean supports(String category) {
        return "Electronics".equals(category); // Supporte uniquement les produits électroniques
    }
}
