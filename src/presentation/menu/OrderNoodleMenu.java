package presentation.menu;

import data.OrderRepositoryImpl;
import domain.entity.BoiledNoodle;
import domain.entity.Menu;
import domain.entity.Noodle;
import domain.repository.OrderRepository;
import domain.usecase.GetBoiledNoodleUseCase;
import domain.usecase.GetFriedNoodleUseCase;
import util.PrintUtil;
import util.ScannerUtil;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderNoodleMenu extends Menu {
    private final Option option;
    private final OrderRepository orderRepository = new OrderRepositoryImpl();

    public OrderNoodleMenu(Option option) {
        this.option = option;
    }

    @Override
    public void printInterface() {
        List<? extends Noodle> noodles;

        if (orderRepository.getTemporaryVariant().equals(BoiledNoodle.VARIANT)) {
            noodles = GetBoiledNoodleUseCase.execute();
        } else {
            noodles = GetFriedNoodleUseCase.execute();
        }

        printSeparator();
        println("Boiled Noodle Menu");
        AtomicInteger number = new AtomicInteger(1);
        noodles.forEach(noodle -> println(PrintUtil.itemWithNumber(number.getAndIncrement(), noodle.getFullName())));
        println(PrintUtil.itemWithNumber(number.get(), "Back"));
        println("Select noodle: ");
        int selectedMenu = scanner.scanInt();

        if (selectedMenu == number.get()) {
            option.back();
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

        orderRepository.setTemporaryNoodle(noodles.get(selectedMenu));
        option.noodleSelected();
    }

    public interface Option {
        void noodleSelected();
        void back();
    }
}
