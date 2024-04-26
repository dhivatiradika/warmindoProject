package presentation.menu;

import domain.entity.Menu;
import util.ScannerUtil;

public class InventoryMenu extends Menu {
    private final Option option;

    public InventoryMenu(Option option) {
        this.option = option;
    }

    @Override
    public void printInterface() {
        printSeparator();
        String menu = """
                Main menu
                1. Add Indomie
                2. Add Topping
                3. Exit
                Select menu:
                """;
        printSeparator();
        print(menu);
        int selectedMenu = scanner.scanInt();

        switch (selectedMenu) {
            case 1:
                option.addNoodle();
                break;
            case 2:
                option.addTopping();
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
        void addNoodle();
        void addTopping();
        void back();
    }
}
