package domain.entity;

public class FriedNoodle extends Noodle {
    @Override
    public int getEstimatedCookingTimeInMinute() {
        return 15;
    }

    @Override
    public void startCooking() {
        System.out.println("Start frying "+getName()+" "+getFlavor()+"...");
    }
}
