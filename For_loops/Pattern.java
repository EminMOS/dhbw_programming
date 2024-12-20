public class Pattern {
    public static void main(String[] args) {
        int height = 7; // Height of the pattern (adjustable)

        // Upper part of the pattern
        for (int i = 1; i <= height / 2 + 1; i++) {
            // Print stars on the left
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Print spaces before the middle star
            for (int j = 1; j <= (height - 2 * i); j++) {
                System.out.print(" ");
            }

            // Print stars on the right
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // Lower part of the pattern
        for (int i = height / 2; i >= 1; i--) {
            // Print stars on the left
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Print spaces before the middle star
            for (int j = 1; j <= (height - 2 * i); j++) {
                System.out.print(" ");
            }

            // Print stars on the right
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
