package presentation.menu;

import domain.entity.Menu;
import util.PrintUtil;
import util.ScannerUtil;

public class MainMenu implements Menu {
    private final Option option;

    public MainMenu(Option option) {
        this.option = option;
    }

    @Override
    public void printInterface() {
        ScannerUtil scanner = new ScannerUtil();
        String print = """
                Main menu
                1. Order
                2. Inventory
                3. Exit
                Select menu:
                """;
        PrintUtil.printSeparator();
        System.out.print(print);
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
                System.out.println("Input not valid");
                printInterface();
                break;
            default:
                System.out.println("Menu not available.");
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
