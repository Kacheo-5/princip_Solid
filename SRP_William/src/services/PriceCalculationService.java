package services;

import entity.ArticleCommande;
import entity.Commande;

public class PriceCalculationService {
    public void calculateTotalPrice(Commande commande) {
        double totalPrice = 0;
        for (ArticleCommande item : commande.getArticles()) {
            if (item.getArticle().getCategory().equals("Electronics")) {
                totalPrice += item.getArticle().getPrice() * 1.2; // Taxe spéciale pour l'électronique
            } else {
                totalPrice += item.getArticle().getPrice();
            }
        }
        commande.setTotalPrice(totalPrice);
    }
}
 