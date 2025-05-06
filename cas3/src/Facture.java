import java.util.List;

public class Facture {
    private List<Produit> produits;

    public Facture(List<Produit> produits) {
        this.produits = produits;
    }

    public List<Produit> getProduits() {
        return produits;
    }
}