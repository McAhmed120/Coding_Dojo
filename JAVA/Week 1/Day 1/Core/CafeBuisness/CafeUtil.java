import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CafeUtil {

    public int getStreakGoal() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        for (int i = 1; i <= maxQuantity; i++) {
            double total = price * i;
            System.out.println(i + " - " + currencyFormat.format(total));
        }
    }

    public double getOrderTotal(double[] prices) {
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        }

        for (int i = 0; i < menuItems.size(); i++) {
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
            System.out.println(i + " " + menuItems.get(i) + " -- " + currencyFormat.format(prices.get(i)));
        }

        return true;
    }

    public void addCustomer(ArrayList<String> customers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String username = scanner.nextLine();
        System.out.println("Hello, " + username + "!");
        System.out.println("There are " + customers.size() + " people in front of you.");

        customers.add(username);
        System.out.println(customers);
    }

    public void addCustomers(ArrayList<String> customers) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer names (type 'q' when done): ");
        String input = scanner.nextLine();
        String[] customerNames = input.split(",");
        customers.addAll(Arrays.asList(customerNames));

        System.out.println("Customers added: " + customers);
    }
}
