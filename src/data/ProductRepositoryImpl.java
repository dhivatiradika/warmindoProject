package data;

import domain.entity.Product;
import domain.repository.ProductRepository;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private final ApplicationData applicationData = ApplicationData.getInstance();

    @Override
    public List<Product> getProducts() {
        return applicationData.getProducts();
    }

    @Override
    public void addProduct(Product product) {
        applicationData.addProduct(product);
    }
}
