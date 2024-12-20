public class ReversePattern {
    public static void main(String[] args) {
        int height = 7; // Height of the pattern (adjustable)

        // Upper part of the pattern (reverse)
        for (int i = height / 2 + 1; i >= 1; i--) {
            // Print stars on the left
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Print spaces in the middle
            for (int j = 1; j <= (height - 2 * i); j++) {
                System.out.print(" ");
            }

            // Print stars on the right
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // Lower part of the pattern (reverse)
        for (int i = 2; i <= height / 2 + 1; i++) {
            // Print stars on the left
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Print spaces in the middle
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
