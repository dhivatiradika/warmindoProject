package util;

public class PrintUtil {
    public static void printSeparator() {
        System.out.println("-------------------------");
    }

    public static <T> String itemWithNumber(int number, T item) {
        return number + ". " + item.toString();
    }
}
