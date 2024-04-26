package presentation.menu;

import data.OrderRepositoryImpl;
import domain.entity.BoiledNoodle;
import domain.entity.FriedNoodle;
import domain.entity.Menu;
import domain.repository.OrderRepository;
import util.ScannerUtil;

public class OrderVariantMenu extends Menu {
    private final Option option;
    private final OrderRepository orderRepository = new OrderRepositoryImpl();

    public OrderVariantMenu(Option option) {
        this.option = option;
    }

    @Override
    public void printInterface() {
        String menu = """
                Variant menu
                1. Fried Noodle
                2. Boiled Noodle
                3. Back
                Select menu:
                """;
        printSeparator();
        print(menu);
        int selectedMenu = scanner.scanInt();

        switch (selectedMenu) {
            case 1:
                orderRepository.setTemporaryVariant(FriedNoodle.VARIANT);
                option.friedNoodle();
                break;
            case 2:
                orderRepository.setTemporaryVariant(BoiledNoodle.VARIANT);
                option.boiledNoodle();
                break;
            case 3:
                option.back();
                break;
            case ScannerUtil.INT_INPUT_MISS_MATCH:
                println("Input not valid");
                printInterface();
                break;
            default:
                println("Menu not available.");
                printInterface();
                break;
        }
    }

    public interface Option {
        void friedNoodle();
        void boiledNoodle();
        void back();
    }
}
