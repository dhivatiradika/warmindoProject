package domain.repository;

import domain.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getProducts();

    void addProduct(Product product);
}