package presentation.menu;

import data.OrderRepositoryImpl;
import domain.entity.Menu;
import domain.entity.Noodle;
import domain.entity.Topping;
import domain.repository.OrderRepository;
import domain.usecase.GetToppingUseCase;
import util.PrintUtil;
import util.ScannerUtil;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ToppingMenu extends Menu {
    private final Option option;
    private final OrderRepository orderRepository = new OrderRepositoryImpl();

    public ToppingMenu(Option option) {
        this.option = option;
    }

    @Override
    public void printInterface() {
        Noodle temporaryNoodle = orderRepository.getTomporaryNoodle();
        List<Topping> toppings = GetToppingUseCase.execute();

        printSeparator();
        println("Topping Menu");
        AtomicInteger number = new AtomicInteger(1);
        toppings.forEach(topping -> println(PrintUtil.itemWithNumber(number.getAndIncrement(), topping.getName())));
        println(PrintUtil.itemWithNumber(number.get(), "No Topping"));
        println("Select topping: ");
        int selectedMenu = scanner.scanInt();

        if (selectedMenu == number.get()) {
            option.noTopping();
            return;
        }

        if (selectedMenu == ScannerUtil.INT_INPUT_MISS_MATCH) {
            println("Input not valid");
            printInterface();
            return;
        }

        if (selectedMenu < 0 || selectedMenu > number.get()) {
            println("Menu not available");
            printInterface();
            return;
        }

        temporaryNoodle.addTopping(toppings.get(selectedMenu-1));
        option.toppingSelected();
    }

    public interface Option {
        void toppingSelected();
        void noTopping();
    }
}

