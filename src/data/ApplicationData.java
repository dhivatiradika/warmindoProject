package data;

import domain.entity.*;

import java.util.ArrayList;
import java.util.List;

public final class ApplicationData {
    private static ApplicationData INSTANCE;
    private final List<Product> productList = new ArrayList<>();
    private Noodle temporaryNoodle;
    private String temporaryVariant;
    private List<Product> orderList = new ArrayList<>();

    private ApplicationData() {
        insertDummyProducts();
    }

    public static ApplicationData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationData();
        }

        return INSTANCE;
    }

    public List<Product> getProducts() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Noodle getTemporaryNoodle() {
        return temporaryNoodle;
    }

    public void setTemporaryNoodle(Noodle temporaryNoodle) {
        this.temporaryNoodle = temporaryNoodle;
    }

    public String getTemporaryVariant() {
        return temporaryVariant;
    }

    public void setTemporaryVariant(String temporaryVariant) {
        this.temporaryVariant = temporaryVariant;
    }

    public void addOrder(Product product) {
        orderList.add(product);
    }

    public List<Product> getOrderList() {
        return orderList;
    }

    private void insertDummyProducts() {
        productList.add(new BoiledNoodle(10, "Indomie Kuah", 5000, "Soto"));
        productList.add(new BoiledNoodle(10, "Indomie Kuah", 5000, "Kari Ayam"));
        productList.add(new BoiledNoodle(10, "Indomie Kuah", 5000, "Ayam Bawang"));
        productList.add(new BoiledNoodle(10, "Indomie Kuah", 5000, "Laksa"));
        productList.add(new FriedNoodle(10, "Indomie Goreng", 5000, "Original"));
        productList.add(new FriedNoodle(10, "Indomie Goreng", 5000, "Rendang"));
        productList.add(new FriedNoodle(10, "Indomie Goreng", 5000, "Sambal Bawang"));
        productList.add(new FriedNoodle(10, "Indomie Goreng", 5000, "Salted Egg"));
        productList.add(new Topping(10, "Telur", 2000));
        productList.add(new Topping(10, "Sosis", 2000));
        productList.add(new Topping(10, "Kornet", 2000));
    }
}
