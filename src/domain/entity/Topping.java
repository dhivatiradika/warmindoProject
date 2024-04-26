package domain.entity;

public class Topping extends Product {

    public Topping(int stock, String name, float price) {
        setStock(stock);
        setName(name);
        setPrice(price);
    }
}
