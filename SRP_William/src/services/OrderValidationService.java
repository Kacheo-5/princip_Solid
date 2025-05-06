package services;

import entity.Commande;

public class OrderValidationService {
    public void validate(Commande commande) {
        if (commande.getArticles().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }
    }
} 
