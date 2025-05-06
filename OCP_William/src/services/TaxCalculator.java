package services;

import entity.Article;

public interface TaxCalculator {
    double calculateTax(Article article);

    default boolean supports(String category) {
        return false; // Par défaut, aucune catégorie n'est supportée
    }
}
