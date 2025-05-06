package services;

import database.MySQLDatabase;
import entity.ArticleCommande;
import entity.Commande;
import exceptions.DatabaseException;
import exceptions.EmailException;

public class CommadeService {
    private final MySQLDatabase database;
    private final SMTPEmailService emailService;
    private final OrderValidationService validationService;
    private final PriceCalculationService priceService;
    private final InventoryService inventoryService;
    private final OrderPersistenceService persistenceService;

    public CommadeService() {
        this.database = new MySQLDatabase();
        this.emailService = new SMTPEmailService();
        this.validationService = new OrderValidationService();
        this.priceService = new PriceCalculationService();
        this.inventoryService = new InventoryService(database);
        this.persistenceService = new OrderPersistenceService(database);
    }

    public void processOrder(Commande commande) {
        try {
            // Validation de la commande
            validationService.validate(commande);

            // Calcul du prix total
            priceService.calculateTotalPrice(commande);

            // Sauvegarde dans la base de données
            persistenceService.saveOrder(commande);

            // Envoi d'un email de confirmation
            String message = "Cher client, votre commande a ete traite. Total: $" + commande.getTotalPrice();
            emailService.sendEmail(commande.getClientEmail(), "Order Confirmation", message);

            // Mise à jour de l'inventaire
            for (ArticleCommande item : commande.getArticles()) {
                inventoryService.updateInventory(item);
            }
        } catch (DatabaseException e) {
            System.err.println("Erreur enregistrement de la commande: " + e.getMessage());
        } catch (EmailException e) {
            System.err.println("Erreur confirmation email: " + e.getMessage());
        }
    }
}