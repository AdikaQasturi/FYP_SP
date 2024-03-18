import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String item;
        double price, discountcut, quantity;
        String choice = "y";

        while (choice == ("y")) {

            System.out.print("Enter item name:");
            item = sc.nextLine();
            System.out.print("Enter item price: (RM)");
            price = sc.nextDouble();
            while (price < 0) {
                System.out.println("Invalid input. Please enter a valid price");
                System.out.print("Enter item price: (RM) ");
                price = sc.nextDouble();
            }

            System.out.print("Enter quantity:");
            quantity = sc.nextDouble();
            while (quantity < 0) {
                System.out.println("Invalid input. Please enter a valid quantity.");
                System.out.print("Enter quantity: ");
                quantity = sc.nextDouble();
            }

            int choiceInt;
            do {
                System.out.println("Select discount percentage:");
                System.out.println("1. 5%");
                System.out.println("2. 10%");
                System.out.println("3. 15%");
                choiceInt = sc.nextInt();
                if (choiceInt < 1 || choiceInt > 3) {
                    System.out.println("Invalid input. Please select a valid discount percentage.");
                }
            } while (choiceInt < 1 || choiceInt > 3);

            switch (choiceInt) {
                case 1:
                    discountcut = 0.05;
                    break;
                case 2:
                    discountcut = 0.1;
                    break;
                case 3:
                    discountcut = 0.15;
                    break;
                default:
                    discountcut = 0;
            }

            double pricetolakSST = price * quantity;
            double tolakharga = discount(price, discountcut);
            double lepasdiscount = pricetolakSST - tolakharga;
            double pricelepasSST = SST(lepasdiscount);

            System.out.println("Item Name: " + item);
            System.out.println("Price Before SST: RM " + pricetolakSST);
            System.out.println("Discount Percentage: " + discountcut * 100 + "%");
            System.out.println("Discount Amount: RM " + tolakharga);
            System.out.println("Price After Discount: RM " + lepasdiscount);
            System.out.println("Price After SST: RM " + pricelepasSST);

            System.out.print("Do you want to calculate the price of another item? (y/n): ");
            choice = sc.next();
        }

    }
    public static double discount(double price, double discountcut) {
        return price * discountcut;
    }
    public static double SST(double price) {
        return price * 1.1;
    }
}
