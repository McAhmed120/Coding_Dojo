public class BankTest {
    public static void main(String[] args) {
        // Create 3 bank accounts
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();

        // Deposit Test
        account1.deposit(100.0, "checking");
        account2.deposit(200.0, "savings");
        account3.deposit(50.0, "checking");
        // Withdrawal Test
        account1.withdraw(30.0, "checking");
        account2.withdraw(50.0, "savings");
        account3.withdraw(80.0, "savings");
        // Static Test
        System.out.println("Number of bank accounts: " + BankAccount.getAccounts());
        System.out.println("Total money across all accounts: $" + BankAccount.getTotalMoney());
    }
}
