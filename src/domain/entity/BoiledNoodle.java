package domain.entity;

public class BoiledNoodle extends Noodle {
    @Override
    public int getEstimatedCookingTimeInMinute() {
        return 12;
    }

    @Override
    public void startCooking() {
        System.out.println("Start boiling "+getName()+" "+getFlavor()+"...");
    }
}
