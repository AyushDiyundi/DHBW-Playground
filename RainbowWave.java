public class RainbowWave {
    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    
    public static void main(String[] args) throws InterruptedException {
        // Print welcome banner
        printBanner();
        
        // Animate a colorful wave
        animateWave();
        
        // Print farewell message
        printFarewell();
    }
    
    public static void printBanner() {
        System.out.println("\n" + CYAN + "╔════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "║  " + YELLOW + "✨  WELCOME TO RAINBOW WAVE!  ✨" + CYAN + "   ║" + RESET);
        System.out.println(CYAN + "╚════════════════════════════════════════╝" + RESET + "\n");
    }
    
    public static void animateWave() throws InterruptedException {
        String[] colors = {RED, YELLOW, GREEN, CYAN, BLUE, PURPLE};
        String[] waves = {"~", "∼", "≈", "∽", "〰", "⁓"};
        
        System.out.println(WHITE + "Creating colorful waves..." + RESET + "\n");
        
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 6; j++) {
                String color = colors[j];
                System.out.print(color);
                
                // Print wave pattern
                for (int k = 0; k < 8; k++) {
                    System.out.print(waves[(i + k) % waves.length] + " ");
                }
                System.out.print(RESET);
            }
            System.out.println();
            Thread.sleep(200); // Pause for animation effect
        }
    }
    
    public static void printFarewell() {
        System.out.println("\n" + GREEN + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + RESET);
        System.out.println(PURPLE + "       🌈 Animation Complete! 🌈" + RESET);
        System.out.println(GREEN + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + RESET);
        System.out.println(YELLOW + "\n✨ Thanks for watching! ✨\n" + RESET);
    }
}