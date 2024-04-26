package presentation.menu;

import data.ProductRepositoryImpl;
import domain.entity.*;
import domain.repository.ProductRepository;

public class AddToppingMenu extends Menu {
    public final Option option;
    private final ProductRepository productRepository = new ProductRepositoryImpl();

    public AddToppingMenu(Option option) {
        this.option = option;
    }

    @Override
    public void printInterface() {
        String name;
        int stock;
        float price;
        printSeparator();
        print("Topping name: ");
        name = scanner.scanString();
        print("Topping stock: ");
        stock = scanner.scanInt();
        print("Topping price: ");
        price = scanner.scanFloat();

        Topping topping = new Topping(stock, name, price);
        productRepository.addProduct(topping);

        option.next();
    }

    public interface Option {
        void next();
    }
}
