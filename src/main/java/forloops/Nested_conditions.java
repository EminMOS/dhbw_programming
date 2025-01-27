package forloops;

import java.util.Scanner;

public class Nested_conditions {

    public static String calculateTicketPrice(int age, boolean isStudent, boolean isSenior) {
        if (age <= 0) {
            return "Invalid age.";
        }
        if (isStudent && age < 30) {
            return "Discounted ticket price for students: $10";
        } else if (isSenior && age >= 60) {
            return "Discounted ticket price for seniors: $15";
        } else {
            return "Regular ticket price: $20";
        } 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user inputs
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = scanner.nextBoolean();
        System.out.print("Are you a senior citizen? (true/false): ");
        boolean isSenior = scanner.nextBoolean();

        // Output ticket price
        System.out.println(calculateTicketPrice(age, isStudent, isSenior));
    }
}
