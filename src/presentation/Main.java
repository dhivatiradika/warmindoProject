package presentation;

import domain.entity.Menu;
import presentation.menu.*;
import presentation.navigation.Navigation;

public class Main {
    public static void main(String[] args) {
        Navigation navigation = new Navigation();

        Menu transactionListMenu = new TransactionListMenu(navigation::backToStart);

        Menu spiceMenu = new SpiceMenu(navigation::backToStart);

        Menu toppingMenu = new ToppingMenu(new ToppingMenu.Option() {
            @Override
            public void toppingSelected() {
                navigation.goTo(spiceMenu);
            }

            @Override
            public void noTopping() {
                navigation.goTo(spiceMenu);
            }
        });

        Menu orderNoodleMenu = new OrderNoodleMenu(new OrderNoodleMenu.Option() {
            @Override
            public void noodleSelected() {
                navigation.goTo(toppingMenu);
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
                navigation.goTo(transactionListMenu);
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