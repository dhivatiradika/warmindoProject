import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Noodle[] nList = {
            new Noodle(2, "Ayam Bawang", "Kuah", 5000),
            new Noodle(1, "Kari Ayam", "Kuah", 5000),
            new Noodle(4, "Soto", "Kuah", 5000),
            new Noodle(5, "Original", "Goreng", 5000),
            new Noodle(2, "Rendang", "Goreng", 5000),
    };

    private static final Topping[] tList = {
            new Topping(3, "Kornet", 1500),
            new Topping(2, "Telur", 3000),
            new Topping(4, "Sosis", 2000),
    };

    public static void main(String[] args) {
        Noodle noodle = null;
        List<Topping> topping = new ArrayList<>();
        int spice = 0;

        Scanner s = new Scanner(System.in);
        String o = "";

        while (!o.equals("5")) {
            System.out.println("Menu:");
            System.out.println("1. Select Indomie");
            System.out.println("2. Select Topping");
            System.out.println("3. Select Spice");
            System.out.println("4. Finish order");
            System.out.println("5. Exit");
            System.out.print("Select menu: ");
            o = s.nextLine();

            switch (o) {
                case "1":
                    System.out.println("Pilih Indomie:");
                    for (int i = 0; i < nList.length; i++) {
                        System.out.println(i + 1 + ". Indomie "+nList[i].type+" "+nList[i].flavor);
                    }
                    int m = s.nextInt() - 1;
                    s.nextLine();
                    if (m >= 0 && m < nList.length) {
                        if (nList[m].stock == 0) {
                            System.out.println("Stock kosong.");
                        } else {
                            noodle = nList[m];
                            nList[m].stock = nList[m].stock - 1;
                        }
                    }
                    break;
                case "2":
                    System.out.println("Pilih Topping:");
                    for (int i = 0; i < tList.length; i++) {
                        System.out.println(i + 1 + ". "+tList[i].name);
                    }
                    int n = s.nextInt() - 1;
                    s.nextLine();
                    if (n >= 0 && n < tList.length) {
                        if (tList[n].stock == 0) {
                            System.out.println("Stock kosong.");
                        } else {
                            topping.add(tList[n]);
                            tList[n].stock = tList[n].stock - 1;
                        }
                    }
                    break;
                case "3":
                    System.out.print("Level pedas: ");
                    spice = s.nextInt();
                    s.nextLine();
                    break;
                case "4":
                    System.out.println("=====================================");
                    if (noodle == null) {
                        System.out.println("Belum memilih Indomie.");
                    } else {
                        if (noodle.type.equals("Kuah")) {
                            System.out.println("Merebus Indomie...");
                        } else {
                            System.out.println("Menggoreng Indomie...");
                        }

                        System.out.print("Indomie "+noodle.type+" "+noodle.flavor);
                        if (topping.size() > 0) {
                            System.out.print(" dengan topping ");
                            for (int i = 0; i < topping.size(); i++) {
                                if (i == topping.size()-1) {
                                    System.out.print(topping.get(i).name);
                                } else {
                                    System.out.print(topping.get(i).name + ", ");
                                }
                            }
                        }
                        System.out.print(" dan level pedas: "+spice+" siap dihidangkan.");
                        System.out.println();
                        System.out.println("=====================================");
                        System.out.println("Receipt");
                        System.out.println("-------------------------------------");
                        int t = 0;
                        t += noodle.price;
                        System.out.format("%-25s %d%n", "Indomie "+noodle.type+" "+noodle.flavor, noodle.price);
                        for (int i = 0; i < topping.size(); i++) {
                            System.out.format(" - %-22s %d%n", topping.get(i).name, topping.get(i).price);
                            t+=topping.get(i).price;
                        }
                        System.out.println("-------------------------------------");
                        System.out.format("%-25s %d%n", "Total", t);
                    }
                    System.out.println("=====================================");

            }

        }
    }
}

class Noodle {
    int stock;
    String flavor;
    String type;
    int price;

    public Noodle(int stock, String flavor, String type, int price) {
        this.stock = stock;
        this.flavor = flavor;
        this.type = type;
        this.price = price;
    }
}

class Topping {
    int stock;
    String name;
    int price;

    public Topping(int stock, String name, int price) {
        this.stock = stock;
        this.name = name;
        this.price = price;
    }
}
