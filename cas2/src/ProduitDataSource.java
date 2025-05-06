import java.util.List;

public interface ProduitDataSource {
    void insert(Produit produit);
    List<Produit> findAll();
}
