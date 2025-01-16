public class LogicGates {

    
    public static int AND(int a, int b) {
        return (a == 1 && b == 1) ? 1 : 0;
    }

   
    public static int OR(int a, int b) {
        return (a == 1 || b == 1) ? 1 : 0;
    }

    
    public static int NOT(int a) {
        return (a == 1) ? 0 : 1;
    }

   
    public static int NAND(int a, int b) {
        return NOT(AND(a, b));
    }

   
    public static int NOR(int a, int b) {
        return NOT(OR(a, b));
    }

    
    public static int XOR(int a, int b) {
        return (a != b) ? 1 : 0;
    }

   
    public static int XNOR(int a, int b) {
        return NOT(XOR(a, b));
    }

   
    public static void printTruthTables() {
        System.out.println("Truth Table for Logic Gates:\n");
        System.out.println("A\tB\tAND\tOR\tNAND\tNOR\tXOR\tXNOR");
        for (int a = 0; a <= 1; a++) {
            for (int b = 0; b <= 1; b++) {
                System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\n",
                        a, b, AND(a, b), OR(a, b), NAND(a, b), NOR(a, b), XOR(a, b), XNOR(a, b));
            }
        }

        System.out.println("\nTruth Table for NOT Gate:\n");
        System.out.println("A\tNOT");
        for (int a = 0; a <= 1; a++) {
            System.out.printf("%d\t%d\n", a, NOT(a));
        }
    }

    public static void main(String[] args) {
        printTruthTables();
    }
}
