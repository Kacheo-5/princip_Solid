import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        ProduitRepository repository;
        System.out.println("Choisissez la source de données:");
        System.out.println("1. En mémoire");
        System.out.println("2. Fichier");
        int choixSource = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        if (choixSource == 1) {
            repository = new ProduitRepository(new InMemoryProduitDataSource());
        } else {
            repository = new ProduitRepository(new FileProduitDataSource());
        }

        while (true) {
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Afficher tous les produits");
            System.out.println("3. Quitter");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            if (choix == 1) {
                System.out.print("Nom du produit: ");
                String nom = scanner.nextLine();
                System.out.print("Prix du produit: ");
                double prix = scanner.nextDouble();
                scanner.nextLine(); // Consommer la nouvelle ligne
                repository.insert(new Produit(nom, prix));
                System.out.println("Produit ajouté avec succès!");
            } else if (choix == 2) {
                System.out.println("Liste des produits:");
                for (Produit produit : repository.findAll()) {
                    System.out.println(produit.getNom() + " - " + produit.getPrix() + " CFA");
                }
            } else if (choix == 3) {
                System.out.println("Au revoir!");
                break;
            } else {
                System.out.println("Option invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
    }
}
