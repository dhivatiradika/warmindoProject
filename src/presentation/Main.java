package presentation;

import domain.entity.Menu;
import presentation.menu.MainMenu;
import presentation.menu.OrderMenu;
import presentation.navigation.Navigation;

public class Main {
    public static void main(String[] args) {
        Navigation navigation = new Navigation();

        Menu orderMenu = new OrderMenu(new OrderMenu.Option() {
            @Override
            public void orderNoodle() {

            }

            @Override
            public void transactionList() {

            }

            @Override
            public void back() {
                navigation.back();
            }
        });

        Menu mainMenu = new MainMenu(new MainMenu.Option() {
            @Override
            public void order() {
                navigation.goTo(orderMenu);
            }

            @Override
            public void inventory() {
                System.out.println("Inventory");
            }

            @Override
            public void exit() {
                //do nothing
            }
        });

        navigation.goTo(mainMenu);
    }
}