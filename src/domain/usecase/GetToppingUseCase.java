package domain.usecase;

import data.ProductRepositoryImpl;
import domain.entity.BoiledNoodle;
import domain.entity.Topping;
import domain.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class GetToppingUseCase {
    private static final ProductRepository repository = new ProductRepositoryImpl();

    public static List<Topping> execute() {
        List<Topping> toppings = new ArrayList<>();

        repository.getProducts().forEach( product -> {
            if (product instanceof Topping) {
                toppings.add((Topping) product);
            }
        });

        return toppings;
    }
}