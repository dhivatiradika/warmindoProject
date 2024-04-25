package presentation.menu;

import domain.entity.Menu;
import util.ScannerUtil;

public class MainMenu extends Menu {
    private final Option option;

    public MainMenu(Option option) {
        this.option = option;
    }

    @Override
    public void printInterface() {
        String menu = """
                Main menu
                1. Order
                2. Inventory
                3. Exit
                Select menu:
                """;
        printSeparator();
        print(menu);
        int selectedMenu = scanner.scanInt();

        switch (selectedMenu) {
            case 1:
                option.order();
                break;
            case 2:
                option.inventory();
                break;
            case 3:
                option.exit();
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
        void order();
        void inventory();
        void exit();
    }
}
