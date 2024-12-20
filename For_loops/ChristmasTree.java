public class ChristmasTree {
    public static void main(String[] args) {
        int height = 5; // Height of the tree

        // Top of the tree
        System.out.println("    +");

        // Tree body with stars
        for (int i = 0; i < height; i++) {
            // Print spaces to center the stars
            for (int j = 0; j < height - i; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 0; j < (2 * i - 1); j++) {
                System.out.print("*");
            }

            // Move to the next line for the next tree layer
            System.out.println();
        }

        // Tree trunk
        for (int i = 0; i < 2; i++) {
            // Print spaces to center the trunk
            for (int j = 1; j < height; j++) {
                System.out.print(" ");
            }
            System.out.println("***");
        }
    }
}
