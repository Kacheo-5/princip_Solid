import entity.Article;
import entity.ArticleCommande;
import entity.Commande;
import java.util.Scanner;
import services.CommadeService;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Création d'une commande manuelle
        System.out.println("Entrez l'ID de la commande :");
        int commandeId = scanner.nextInt();
        System.out.println("Entrez l'ID du client :");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne
        System.out.println("Entrez l'email du client :");
        String clientEmail = scanner.nextLine();

        Commande commande = new Commande(commandeId, clientId, clientEmail);

        // Ajout d'articles à la commande
        while (true) {
            System.out.println("Voulez-vous ajouter un article à la commande ? (oui/non)");
            String reponse = scanner.nextLine();
            if (!reponse.equalsIgnoreCase("oui")) {
                break;
            }

            System.out.println("Entrez l'ID de l'article :");
            int articleId = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne
            System.out.println("Entrez le nom de l'article :");
            String articleName = scanner.nextLine();
            System.out.println("Entrez la catégorie de l'article :");
            String articleCategory = scanner.nextLine();
            System.out.println("Entrez le prix de l'article :");
            double articlePrice = scanner.nextDouble();
            System.out.println("Entrez la quantité en stock de l'article :");
            int articleStock = scanner.nextInt();
            System.out.println("Entrez la quantité à commander :");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            Article article = new Article(articleId, articleName, articleCategory, articlePrice, articleStock);
            commande.addItem(new ArticleCommande(article, quantity));
        }

        // Traitement de la commande
        CommadeService commadeService = new CommadeService();
        commadeService.processOrder(commande);

        System.out.println("Commande traitée avec succès.");
        scanner.close();
    }
}
