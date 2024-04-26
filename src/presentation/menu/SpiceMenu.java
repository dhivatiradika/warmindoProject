package presentation.menu;

import data.OrderRepositoryImpl;
import domain.entity.Menu;
import domain.entity.Noodle;
import domain.repository.OrderRepository;
import util.ScannerUtil;

public class SpiceMenu extends Menu {
    private final Option option;
    private final OrderRepository orderRepository = new OrderRepositoryImpl();

    public SpiceMenu(Option option) {
        this.option = option;
    }

    @Override
    public void printInterface() {
        Noodle temporaryNoodle = orderRepository.getTomporaryNoodle();

        printSeparator();
        print("Spice level (0-5): ");
        int selectedMenu = scanner.scanInt();

        if (selectedMenu == ScannerUtil.INT_INPUT_MISS_MATCH) {
            println("Input not valid");
            printInterface();
            return;
        }

        if (selectedMenu < 0 || selectedMenu > 5) {
            println("Menu not available");
            printInterface();
            return;
        }

        temporaryNoodle.setSpice(selectedMenu);
        orderRepository.addOrder(temporaryNoodle);

        printSeparator();
        temporaryNoodle.startCooking();
        option.next();
    }

    public interface Option {
        void next();
    }
}
