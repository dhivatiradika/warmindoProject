package presentation.menu;

import domain.entity.Menu;
import util.ScannerUtil;

public class OrderMenu extends Menu {
    private final Option option;

    public OrderMenu(Option option) {
        this.option = option;
    }

    @Override
    public void printInterface() {
        String menu = """
                Order menu
                1. Indomie Order
                2. Transaction List
                3. Back
                Select Menu:
                """;

        printSeparator();
        print(menu);
        int selectedMenu = scanner.scanInt();

        switch (selectedMenu) {
            case 1:
                option.orderNoodle();
                break;
            case 2:
                option.transactionList();
                break;
            case 3:
                option.back();
                break;
            case ScannerUtil.INT_INPUT_MISS_MATCH:
                println("Input not valid");
                printInterface();
                break;
            default:
                println("Menu not available");
                printInterface();
                break;
        }
    }

    public interface Option {
        void orderNoodle();
        void transactionList();
        void back();
    }
}
