package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtil {
    public static final int INT_INPUT_MISS_MATCH = -1;
    private final Scanner scanner = new Scanner(System.in);

    public int scanInt() {
        try {
            int value = scanner.nextInt();
            scanner.nextLine();
            return value;
        } catch (InputMismatchException exception) {
            return INT_INPUT_MISS_MATCH;
        }
    }

    public String scanString() {
        return scanner.nextLine();
    }

    public float scanFloat() {
        float value = scanner.nextFloat();
        scanner.nextLine();
        return value;
    }
}

