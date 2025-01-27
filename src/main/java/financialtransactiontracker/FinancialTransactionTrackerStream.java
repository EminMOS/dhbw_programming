package financialtransactiontracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinancialTransactionTrackerStream {

    public static void main(String[] args) {
        List<String[]> transactions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nFinancial Transaction Tracker");
            System.out.println("1. Add Transaction");
            System.out.println("2. Transactions Yesterday");
            System.out.println("3. Total Income and Expense");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> { // Add Transaction
                    System.out.print("Enter type (Purchase/Sale): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    LocalDate date = LocalDate.now();
                    transactions.add(new String[]{type, String.valueOf(amount), date.toString()});
                    System.out.println("Transaction added.");
                }
                case 2 -> { // Transactions Yesterday
                    LocalDate yesterday = LocalDate.now().minusDays(1);
                    long count = transactions.stream()
                            .filter(t -> t[2].equals(yesterday.toString()))
                            .count();
                    System.out.println("Transactions yesterday: " + count);
                }
                case 3 -> { // Total Income and Expense
                    double totalIncome = transactions.stream()
                            .filter(t -> t[0].equalsIgnoreCase("Sale"))
                            .mapToDouble(FinancialTransactionTrackerStream::parseAmount)
                            .sum();

                    double totalExpense = transactions.stream()
                            .filter(t -> t[0].equalsIgnoreCase("Purchase"))
                            .mapToDouble(FinancialTransactionTrackerStream::parseAmount)
                            .sum();

                    System.out.println("Total Income: " + totalIncome);
                    System.out.println("Total Expense: " + totalExpense);
                }
                case 4 -> { // Exit
                    System.out.println("Exiting tracker. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static double parseAmount(String[] transaction) {
        return Double.parseDouble(transaction[1]);
    }
}

