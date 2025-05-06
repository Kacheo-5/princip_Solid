import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SauvegardeFacture {
    public void sauvegarder(String nomFichier, List<Produit> produits, double total) throws IOException {
        try (PrintWriter writer = new PrintWriter(new File(nomFichier))) {
            writer.println("===== FACTURE =====");
            produits.forEach(p -> writer.println(p.getNom() + " - " + p.getPrix() + "xof"));
            writer.println("Total: " + total + "xof");
        }
    }
}
