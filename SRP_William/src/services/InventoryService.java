package services;

import database.MySQLDatabase;
import entity.Article;
import entity.ArticleCommande; 
import exceptions.DatabaseException;

public class InventoryService {
    private final MySQLDatabase database;

    public InventoryService(MySQLDatabase database) {
        this.database = database;
    }

    public void updateInventory(ArticleCommande item) throws DatabaseException {
        Article article = item.getArticle();
        article.setStock(article.getStock() - item.getQuantity());

        String updateSql = "UPDATE article SET stock = ? WHERE id = ?";
        database.executeUpdate(updateSql, article.getStock(), article.getId());
    }
}
