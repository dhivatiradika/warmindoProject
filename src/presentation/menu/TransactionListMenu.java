package presentation.menu;

import data.OrderRepositoryImpl;
import domain.entity.Menu;
import domain.entity.Noodle;
import domain.entity.Product;
import domain.entity.Topping;
import domain.repository.OrderRepository;
import util.PrintUtil;

import java.util.List;

public class TransactionListMenu extends Menu {
    private final Option option;
    private final OrderRepository orderRepository = new OrderRepositoryImpl();

    public TransactionListMenu(Option option) {
        this.option = option;
    }

    @Override
    public void printInterface() {
        List<Product> orders = orderRepository.getOrderList();
        float total = 0;

        printSeparator();
        if (orders.isEmpty()) {
            println("No orders.");
            option.next();
            return;
        }

        println("Receipt");
        printSeparator();
        for (Product order : orders) {
            if (order instanceof Noodle) {
                PrintUtil.itemWithPrice(order.getPrice(), ((Noodle) order).getFullName());
                total+=order.getPrice();

                for (Topping topping : ((Noodle) order).getToppings()) {
                    PrintUtil.childItemWithPrice(topping.getPrice(), topping.getName());
                    total+=topping.getPrice();
                }
            }
        }
        printSeparator();
        PrintUtil.itemWithPrice(total, "Total");
        option.next();
    }

    public interface Option {
        void next();
    }
}
