package domain.usecase;

import data.ProductRepositoryImpl;
import domain.entity.BoiledNoodle;
import domain.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class GetBoiledNoodleUseCase {
    private static final ProductRepository repository = new ProductRepositoryImpl();

    public static List<BoiledNoodle> execute() {
        List<BoiledNoodle> noodles = new ArrayList<>();

        repository.getProducts().forEach( product -> {
            if (product instanceof BoiledNoodle && product.getStock() > 0) {
                noodles.add((BoiledNoodle) product);
            }
        });

        return noodles;
    }
}
