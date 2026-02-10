import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDate;
public class TransactionHash {

    public static void main(String[] args) {
        // Initialization
        HashMap<Integer, String> transactionsList = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int id = 1;
        // Options display
        String optionsHeader = "Transactions Application: Select an option";
        String option1 = "1. Add transaction";
        String option2 = "2. Yesterday's transaction";
        String option3 = "3. Total income";
        String option4 = "4. Print all";
        String option5 = "5. Exit";
        String options = option1 + "\n" + option2 + "\n" + option3 + "\n" + option4 + "\n" + option5;
        String displayOptions = "\n" +optionsHeader + "\n" + options;
        
        while (true) {
            System.out.println(displayOptions);
            
            // Getting user input
            System.out.print("Enter Choice: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            
            switch (userChoice) {
                case 1:
                    // get transaction type
                    System.out.println("Enter the transaction type: (Sales or Purchases)");
                    String transactionType = scanner.nextLine();
                    // get amount
                    System.out.println("Enter the amount");
                    double amount = scanner.nextDouble();
                    // get date
                    LocalDate date = LocalDate.now();
                    // add to transactions
                    String transactionLine = transactionType + "," + amount + "," + date;
                    transactionsList.put(id,transactionLine);
                    id++;
                    System.out.println("Transaction added ");
                    break;
                case 2:
                    LocalDate yesterday = LocalDate.now().minusDays(1);
                    boolean foundYesterday = false;
                    System.out.println("Yesterday's Transactions (" + yesterday + "):");
                    for (Map.Entry<Integer, String> entry : transactionsList.entrySet()) {
                        String[] parts = entry.getValue().split(",");
                        LocalDate transactionDate = LocalDate.parse(parts[2]);
                        if (transactionDate.equals(yesterday)) {
                            System.out.println("Transaction ID: " + entry.getKey() + ", Type: " + parts[0] + ", Amount: " + parts[1]);
                            foundYesterday = true;
                        }
                    }
                    if (!foundYesterday) {
                        System.out.println("No transactions found for yesterday.");
                    }
                    break;
                case 3: // Total income
                    double totalIncome = 0.0;
                    for (Map.Entry<Integer, String> entry : transactionsList.entrySet()) {
                        String[] parts = entry.getValue().split(",");
                        String type = parts[0];
                        double transAmount = Double.parseDouble(parts[1]);
                        if (type.equalsIgnoreCase("Sales")) {
                            totalIncome += transAmount;
                        }
                    }
                    System.out.println("Total Income from Sales: " + totalIncome);
                    break;
                case 4: // Print All
                    System.out.println("List of Transactions:");
                    for (Map.Entry<Integer, String> entry : transactionsList.entrySet()) {
                        System.out.println("Transaction ID: " + entry.getKey() + ", Details: " + entry.getValue());
                    }
                    break;
                case 5:
                    scanner.close();
                    return;

                default:
                    break;
            }
            
        }
        
    }
}