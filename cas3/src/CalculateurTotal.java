import java.util.List;

public class CalculateurTotal {
    public double calculer(List<Produit> produits) {
        return produits.stream().mapToDouble(Produit::getPrix).sum();
    }
}
