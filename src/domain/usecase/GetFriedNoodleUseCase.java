package domain.usecase;

import data.ProductRepositoryImpl;
import domain.entity.FriedNoodle;
import domain.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class GetFriedNoodleUseCase {
    private static final ProductRepository repository = new ProductRepositoryImpl();

    public static List<FriedNoodle> execute() {
        List<FriedNoodle> noodles = new ArrayList<>();

        repository.getProducts().forEach( product -> {
            if (product instanceof FriedNoodle && product.getStock() > 0) {
                noodles.add((FriedNoodle) product);
            }
        });

        return noodles;
    }
}
