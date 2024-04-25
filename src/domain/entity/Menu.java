package domain.entity;

import util.PrintUtil;
import util.ScannerUtil;

public abstract class Menu {
    public ScannerUtil scanner = new ScannerUtil();

    public abstract void printInterface();

    public void print(String text) {
        System.out.print(text);
    }

    public void println(String text) {
        System.out.println(text);
    }

    public void printSeparator() {
        PrintUtil.printSeparator();
    }
}
