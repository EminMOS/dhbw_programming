import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FinancialTransactionTracker {

   private final ArrayList<String> transactions;

    public FinancialTransactionTracker() {
        transactions = new ArrayList<>();
    }

    // Add a new transaction
    public void addTransaction(String type, double amount, String date) {
        String transaction = type + "," + amount + "," + date;
        transactions.add(transaction);
    }

    // Count transactions from yesterday
    public int countTransactionsFromYesterday() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        int count = 0;
        for (String transaction : transactions) {
            String[] parts = transaction.split(",");
            if (parts[2].equals(yesterday.toString())) {
                count++;
            }
        }
        return count;
    }

    // Calculate total income (Sales) and total expenses (Purchases)
    public double[] calculateIncomeAndExpenses() {
        double totalIncome = 0.0;
        double totalExpenses = 0.0;

        for (String transaction : transactions) {
            String[] parts = transaction.split(",");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            if (type.equalsIgnoreCase("Sales")) {
                totalIncome += amount;
            } else if (type.equalsIgnoreCase("Purchase")) {
                totalExpenses += amount;
            }
        }

        return new double[]{totalIncome, totalExpenses};
    }

    // Main method for testing
    public static void main(String[] args) {
        FinancialTransactionTracker tracker = new FinancialTransactionTracker();
        Scanner scanner = new Scanner(System.in);

        // Sample menu-driven program
        while (true) {
            System.out.println("\nFinancial Transaction Tracker");
            System.out.println("1. Add Transaction");
            System.out.println("2. Count Transactions from Yesterday");
            System.out.println("3. Calculate Income and Expenses");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
    case 1 -> {
        System.out.print("Enter type (Sales/Purchase): ");
        String type = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        tracker.addTransaction(type, amount, date);
        System.out.println("Transaction added successfully.");
    }
    case 2 -> {
        int count = tracker.countTransactionsFromYesterday();
        System.out.println("Transactions from yesterday: " + count);
    }
    case 3 -> {
        double[] results = tracker.calculateIncomeAndExpenses();
        System.out.println("Total Income (Sales): " + results[0]);
        System.out.println("Total Expenses (Purchases): " + results[1]);
    }
    case 4 -> {
        System.out.println("Exiting program. Goodbye!");
        scanner.close();
        System.exit(0);
    }
    default -> System.out.println("Invalid option. Please try again.");
}

        }
    }

}