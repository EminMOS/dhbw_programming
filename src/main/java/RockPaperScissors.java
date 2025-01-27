import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Random random = new Random();
        String[] choices = {"rock", "paper", "scissors"};
        boolean playAgain = true;

        System.out.println("Welcome to Rock Paper Scissors!");

        try (Scanner scanner = new Scanner(System.in)) {
            while (playAgain) {
                System.out.print("Enter your choice (rock, paper, scissors): ");
                String userChoice = scanner.nextLine().toLowerCase();

                // Check for valid input
                if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }

                // Computer's choice
                String computerChoice = choices[random.nextInt(3)];
                System.out.println("Computer chose: " + computerChoice);

                // Determine the winner
                if (userChoice.equals(computerChoice)) {
                    System.out.println("It's a tie!");
                } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                           (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                           (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }

                // Ask if the user wants to play again
                System.out.print("Do you want to play again? (yes/no): ");
                String response = scanner.nextLine().toLowerCase();
                if (!response.equals("yes")) {
                    playAgain = false;
                }
            }
        }

        System.out.println("Thanks for playing!");
    }
}
