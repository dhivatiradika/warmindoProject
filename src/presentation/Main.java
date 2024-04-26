package presentation;

import domain.entity.Menu;
import presentation.menu.MainMenu;
import presentation.menu.OrderMenu;
import presentation.menu.OrderNoodleMenu;
import presentation.menu.OrderVariantMenu;
import presentation.navigation.Navigation;

public class Main {
    public static void main(String[] args) {
        Navigation navigation = new Navigation();

        Menu orderNoodleMenu = new OrderNoodleMenu(new OrderNoodleMenu.Option() {
            @Override
            public void noodleSelected() {

            }

            @Override
            public void back() {
                navigation.back();
            }
        });

        Menu orderVariantMenu = new OrderVariantMenu(new OrderVariantMenu.Option() {
            @Override
            public void friedNoodle() {
                navigation.goTo(orderNoodleMenu);
            }

            @Override
            public void boiledNoodle() {
                navigation.goTo(orderNoodleMenu);
            }

            @Override
            public void back() {
                navigation.back();
            }
        });

        Menu orderMenu = new OrderMenu(new OrderMenu.Option() {
            @Override
            public void orderNoodle() {
                navigation.goTo(orderVariantMenu);
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