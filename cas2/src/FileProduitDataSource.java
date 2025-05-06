import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProduitDataSource implements ProduitDataSource {
    private final String nomFichier = "produits.txt";

    @Override
    public void insert(Produit produit) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomFichier, true))) {
            writer.println(produit.getNom() + " - " + produit.getPrix() + " CFA");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parts = ligne.split(" - ");
                String nom = parts[0];
                double prix = Double.parseDouble(parts[1].replace("CFA", "").trim());
                produits.add(new Produit(nom, prix));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return produits;
    }
}
