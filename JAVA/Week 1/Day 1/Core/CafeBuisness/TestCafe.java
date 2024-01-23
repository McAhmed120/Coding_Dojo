import java.util.ArrayList;
import java.util.Arrays; /

public class TestCafe {
    public static void main(String[] args) {
        
        CafeUtil appTest = new CafeUtil(); 
    
        System.out.println("Streak Goal Test");
        System.out.printf("Purchases needed by week 10: %s ", appTest.getStreakGoal());
    
        System.out.println("Print Price Chart Test ");
        appTest.printPriceChart("Columbian Coffee Grounds", 15.0, 3);
    
        System.out.println(" Order Total Test");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n", appTest.getOrderTotal(lineItems));
        
        System.out.println("Display Menu Test");
        ArrayList<String> menu = new ArrayList<>(Arrays.asList("drip coffee", "cappuccino", "latte", "mocha"));
        ArrayList<Double> prices = new ArrayList<>(Arrays.asList(1.5, 3.5, 4.5, 3.5));
        appTest.displayMenu(menu, prices);
    
        System.out.println(" Add Customer Test");
        ArrayList<String> customers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }
        appTest.addCustomers(customers);
    }
}