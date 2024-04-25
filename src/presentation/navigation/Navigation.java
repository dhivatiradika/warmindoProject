package presentation.navigation;

import domain.entity.Menu;

import java.util.Stack;

public class Navigation {
    private final Stack<Menu> navigationStack = new Stack<>();

    public void goTo(Menu menu) {
        navigationStack.push(menu);
        menu.printInterface();
    }

    public void back() {
        navigationStack.pop();
        navigationStack.lastElement().printInterface();
    }
}
