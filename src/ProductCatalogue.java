import java.util.List;

interface ProductCatalogue {
    List<Product> getAllProducts();
}

class InMemoryProductCatalogue implements ProductCatalogue {
    private List<Product> products;

    public InMemoryProductCatalogue(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }
}