import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Produit> produits = new ArrayList<>();

        System.out.println("Ajoutez des produits à la facture (tapez 'fin' pour terminer) :");
        while (true) {
            System.out.print("Nom du produit : ");
            String nom = scanner.nextLine();
            if (nom.equalsIgnoreCase("fin")) break;

            System.out.print("Prix du produit : ");
            double prix = Double.parseDouble(scanner.nextLine());

            produits.add(new Produit(nom, prix));
        }

        Facture facture = new Facture(produits);
        CalculateurTotal calculateur = new CalculateurTotal();
        double total = calculateur.calculer(facture.getProduits());

        ImprimeurFacture imprimeur = new ImprimeurFacture();
        imprimeur.imprimer(facture.getProduits(), total);

        System.out.print("Voulez-vous sauvegarder la facture dans un fichier ? (oui/non) : ");
        String reponse = scanner.nextLine();
        if (reponse.equalsIgnoreCase("oui")) {
            System.out.print("Nom du fichier : ");
            String nomFichier = scanner.nextLine();
            SauvegardeFacture sauvegarde = new SauvegardeFacture();
            sauvegarde.sauvegarder(nomFichier, facture.getProduits(), total);
            System.out.println("Facture sauvegardée dans le fichier : " + nomFichier);
        }

        scanner.close();
    }
}
