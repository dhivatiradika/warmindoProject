package util;

public class PrintUtil {
    public static void printSeparator() {
        System.out.println("-------------------------");
    }

    public static <T> String itemWithNumber(int number, T item) {
        return number + ". " + item.toString();
    }

    public static <T> void itemWithPrice(float price, T item) {
        System.out.format("%-25s %d%n", item.toString(), Math.round(price));
    }

    public static <T> void childItemWithPrice(float price, T item) {
        System.out.format(" - %-22s %d%n", item.toString(), Math.round(price));
    }
}
