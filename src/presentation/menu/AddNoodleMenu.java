package presentation.menu;

import data.ProductRepositoryImpl;
import domain.entity.BoiledNoodle;
import domain.entity.FriedNoodle;
import domain.entity.Menu;
import domain.entity.Noodle;
import domain.repository.ProductRepository;

public class AddNoodleMenu extends Menu {
    public final Option option;
    private final ProductRepository productRepository = new ProductRepositoryImpl();

    public AddNoodleMenu(Option option) {
        this.option = option;
    }

    @Override
    public void printInterface() {
        int type;
        String name;
        int stock;
        String flavor;
        float price;
        printSeparator();
        String typeMenu = """
                Noodle type
                1. Fried Noodle
                2. Boiled Noodle
                Select type:
                """;
        println(typeMenu);
        type = scanner.scanInt();
        print("Noodle name: ");
        name = scanner.scanString();
        print("Noodle stock: ");
        stock = scanner.scanInt();
        print("Noodle flavor: ");
        flavor = scanner.scanString();
        print("Noodle price: ");
        price = scanner.scanFloat();

        if (type == 1) {
            FriedNoodle noodle = new FriedNoodle(stock, name, price, flavor);
            productRepository.addProduct(noodle);
        } else {
            BoiledNoodle noodle = new BoiledNoodle(stock, name, price, flavor);
            productRepository.addProduct(noodle);
        }

        option.next();
    }

    public interface Option {
        void next();
    }
}
