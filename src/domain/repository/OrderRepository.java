package domain.repository;

import domain.entity.Noodle;
import domain.entity.Product;

import java.util.List;

public interface OrderRepository {
    Noodle getTomporaryNoodle();
    void setTemporaryNoodle(Noodle noodle);
    String getTemporaryVariant();
    void setTemporaryVariant(String variant);
    void addOrder(Product product);
    List<Product> getOrderList();
}
