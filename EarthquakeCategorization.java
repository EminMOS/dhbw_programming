import java.util.Scanner;

public class EarthquakeCategorization {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get user input for earthquake magnitude
            System.out.print("Enter the earthquake magnitude: ");
            double magnitude = scanner.nextDouble();

            // Determine the category using conditional expressions
            int category = (magnitude < 2.0) ? 1 :
                           (magnitude < 4.0) ? 2 :
                           (magnitude < 5.0) ? 3 :
                           (magnitude < 6.0) ? 4 :
                           (magnitude < 7.0) ? 5 :
                           (magnitude < 8.0) ? 6 : 7;

            // Output the category and advice using a rule switch
            String advice = switch (category) {
                case 1 -> "Category: Micro\nAdvice: Detected only by seismographs.";
                case 2 -> "Category: Minor\nAdvice: Rarely felt, but recorded.";
                case 3 -> "Category: Light\nAdvice: Felt by people, minor damage.";
                case 4 -> "Category: Moderate\nAdvice: Can cause damage in populated areas. Stay indoors.";
                case 5 -> "Category: Strong\nAdvice: Serious damage in areas up to 100 miles. Be cautious.";
                case 6 -> "Category: Major\nAdvice: Severe damage over large areas. Evacuate if necessary.";
                case 7 -> "Category: Great\nAdvice: Massive destruction. Evacuate immediately.";
                default -> "Invalid magnitude entered.";
            };

            // Print the advice
            System.out.println(advice);
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid number.");
        }
    }
}