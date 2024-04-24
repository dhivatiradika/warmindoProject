package domain.entity;

import java.util.UUID;

abstract class Product {
    final UUID id = UUID.randomUUID();
    private int stock = 0;
    private String name;
    private float price = 0;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isStockAvailable() {
        return stock > 0;
    }

    public void increaseStockBy(int amount) {
        stock += amount;
    }

    public void decreaseStockBy(int amount) {
        stock -= amount;
    }
}
