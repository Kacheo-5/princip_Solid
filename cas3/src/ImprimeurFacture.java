import java.util.List;

public class ImprimeurFacture {
    public void imprimer(List<Produit> produits, double total) {
        System.out.println("===== FACTURE =====");
        produits.forEach(p -> System.out.println(p.getNom() + " - " + p.getPrix() + "xof"));
        System.out.println("Total: " + total + "xof");
    }
}
