import java.util.*;

public class EarthquakeCategorization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the earthquake magnitude");
        double mag = 0.0;
        
        try {
            mag = scanner.nextDouble();
            if (mag < 0) {
                System.out.println("Magnitude can't be negative");
                return;
            }
            
        } catch (InputMismatchException e) {
            System.out.println("Please Enter a Valid Number");
            return;
        }
        
        int category = (mag < 2.0) ? 1 :
                (mag < 4.0) ? 2 :
                        (mag < 5.0) ? 3 :
                                (mag < 6.0) ? 4 :
                                        (mag < 7.0) ? 5 :
                                                (mag < 8.0) ? 6 : 7;
        
        switch (category) {
            case 1 -> {
                System.out.println("Category: Micro");
                System.out.println("Advice: No action needed. Only detected by seismographs.");
            }
            case 2 -> {
                System.out.println("Category: Minor");
                System.out.println("Advice: Rarely felt, but stay alert.");
            }
            case 3 -> {
                System.out.println("Category: Light");
                System.out.println("Advice: Be careful of falling objects from shelves.");
            }
            case 4 -> {
                System.out.println("Category: Moderate");
                System.out.println("Advice: Stay indoors and move away from windows.");
            }
            case 5 -> {
                System.out.println("Category: Strong");
                System.out.println("Advice: Seek cover under sturdy furniture immediately.");
            }
            case 6 -> {
                System.out.println("Category: Major");
                System.out.println("Advice: Evacuate if you are in a weak structure; expect severe damage.");
            }
            case 7 -> {
                System.out.println("Category: Great");
                System.out.println("Advice: EVACUATE IMMEDIATELY. Massive destruction expected.");
            }
            default -> System.out.println("Invalid category detected.");
        }
    }
}