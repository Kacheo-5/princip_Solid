import java.util.List;

public class ProduitRepository {
    private ProduitDataSource dataSource;

    public ProduitRepository(ProduitDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Produit produit) {
        dataSource.insert(produit);
    }

    public List<Produit> findAll() {
        return dataSource.findAll();
    }
}
