import java.util.ArrayList;
import java.util.List;

public class InMemoryProduitDataSource implements ProduitDataSource {
    private List<Produit> produits = new ArrayList<>();

    @Override
    public void insert(Produit produit) {
        produits.add(produit);
    }

    @Override
    public List<Produit> findAll() {
        return produits;
    }
}
