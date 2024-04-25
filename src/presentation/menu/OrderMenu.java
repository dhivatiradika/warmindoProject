package presentation.menu;

import domain.entity.Menu;
import util.PrintUtil;
import util.ScannerUtil;

import java.util.Scanner;

public class OrderMenu implements Menu {
    private final Option option;

    public OrderMenu(Option option) {
        this.option = option;
    }

    @Override
    public void printInterface() {

        ScannerUtil scanner = new ScannerUtil();
        String print = """
                Order menu
                1. Indomie Order
                2. Transaction List
                3. Back
                Select Menu:
                """;

        PrintUtil.printSeparator();
        System.out.print(print);
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
                printInterface();
                break;
            default:
                System.out.println("Menu not available");
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
