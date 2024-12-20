public class ChristmasTree {
    public static void main(String[] args) {
        int height = 5; 


        System.out.print("     +");


        for (int i = 0; i < height; i++) {

            for (int j = 0; j <= height - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < height; j++) {
                System.out.print(" ");
            }
            System.out.println("***");
        }
    }
}
