package domain.entity;

abstract class Noodle extends Product implements Cookable {
    private String flavor;

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}
