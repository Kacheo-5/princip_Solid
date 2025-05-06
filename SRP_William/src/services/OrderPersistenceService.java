package services;

import database.MySQLDatabase;
import entity.ArticleCommande;
import entity.Commande;
import exceptions.DatabaseException;

public class OrderPersistenceService {
    private final MySQLDatabase database;

    public OrderPersistenceService(MySQLDatabase database) {
        this.database = database;
    }

    public void saveOrder(Commande commande) throws DatabaseException {
        String sql = "INSERT INTO commandes (customer_id, total_price) VALUES (?, ?)";
        database.executeUpdate(sql, commande.getClientId(), commande.getTotalPrice());

        for (ArticleCommande item : commande.getArticles()) {
            String itemSql = "INSERT INTO commande_article (order_id, product_id, quantity) VALUES (?, ?, ?)";
            database.executeUpdate(itemSql, commande.getId(), item.getArticle().getId(), item.getQuantity());
        }
    }
}
