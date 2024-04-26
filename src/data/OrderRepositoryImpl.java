package data;

import domain.entity.Noodle;
import domain.entity.Product;
import domain.repository.OrderRepository;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private final ApplicationData applicationData = ApplicationData.getInstance();

    @Override
    public Noodle getTomporaryNoodle() {
        return applicationData.getTemporaryNoodle();
    }

    @Override
    public void setTemporaryNoodle(Noodle noodle) {
        applicationData.setTemporaryNoodle(noodle);
    }

    @Override
    public String getTemporaryVariant() {
        return applicationData.getTemporaryVariant();
    }

    @Override
    public void setTemporaryVariant(String variant) {
        applicationData.setTemporaryVariant(variant);
    }

    @Override
    public void addOrder(Product product) {
        applicationData.addOrder(product);
    }

    @Override
    public List<Product> getOrderList() {
        return applicationData.getOrderList();
    }
}
