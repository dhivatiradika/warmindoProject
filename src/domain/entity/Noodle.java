package domain.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Noodle extends Product implements Cookable {
    private String flavor;
    private final List<Topping> toppings = new ArrayList<>();
    private int spice;

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getFullName() {
        return getName() + " " + getFlavor();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public int getSpice() {
        return spice;
    }

    public void setSpice(int spice) {
        this.spice = spice;
    }
}
