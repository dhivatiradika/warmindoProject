package domain.entity;

public class BoiledNoodle extends Noodle {
    public static final String VARIANT = "BoiledNoodle";

    public BoiledNoodle(int stock, String name, float price, String flavor) {
        setStock(stock);
        setName(name);
        setPrice(price);
        setFlavor(flavor);
    }

    @Override
    public int getEstimatedCookingTimeInMinute() {
        return 12;
    }

    @Override
    public void startCooking() {
        System.out.println("Start boiling "+getName()+" "+getFlavor()+"...");
    }
}
