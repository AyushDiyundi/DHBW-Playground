public class TruthTable {

    // Define the AND function (per your style)
    public static int AND(int a, int b) {
        return (a == 1 && b == 1) ? 1 : 0;
    }

    // Define the OR function
    public static int OR(int a, int b) {
        return (a == 1 || b == 1) ? 1 : 0;
    }

    // Define the XOR function
    public static int XOR(int a, int b) {
        return (a != b) ? 1 : 0;
    }

    // Define the NOT function
    public static int NOT(int a) {
        return (a == 0) ? 1 : 0;
    }

    public static void main(String[] args) {
        // Table Header
        System.out.println("A  B | AND OR  XOR NOT_A");
        System.out.println("-------------------------");

        int[] inputs = {1, 0};

        for (int a : inputs) {
            for (int b : inputs) {
                // Calculate results using the functions
                int andRes = AND(a, b);
                int orRes  = OR(a, b);
                int xorRes = XOR(a, b);
                int notA   = NOT(a);

                // Print formatted row
                System.out.printf("%d  %d |  %d   %d   %d    %d%n",
                        a, b, andRes, orRes, xorRes, notA);
            }
        }
    }
}