package domain.entity;

public class FriedNoodle extends Noodle {
    public static final String VARIANT = "FriedNoodle";

    public FriedNoodle(int stock, String name, float price, String flavor) {
        setStock(stock);
        setName(name);
        setPrice(price);
        setFlavor(flavor);
    }

    @Override
    public int getEstimatedCookingTimeInMinute() {
        return 15;
    }

    @Override
    public void startCooking() {
        System.out.println("Start frying "+getName()+" "+getFlavor()+"...");
    }
}
