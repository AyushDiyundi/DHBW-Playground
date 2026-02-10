import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TransactionList {

    private static final class Transaction {
        private final String type;
        private final double amount;
        private final LocalDate date;

        Transaction(String type, double amount, LocalDate date) {
            this.type = type;
            this.amount = amount;
            this.date = date;
        }
    }

    public static void main(String[] args) {
        // Initialization
        List<Transaction> transactionsList = new ArrayList<>();
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
                    scanner.nextLine();
                    // get date
                    LocalDate date = LocalDate.now();
                    // add to transactions
                    transactionsList.add(new Transaction(transactionType, amount, date));
                    id++;
                    System.out.println("Transaction added ");
                    break;
                case 2:
                    LocalDate yesterday = LocalDate.now().minusDays(1);
                    boolean foundYesterday = false;
                    System.out.println("Yesterday's Transactions (" + yesterday + "):");
                    for (int i = 0; i < transactionsList.size(); i++) {
                        Transaction t = transactionsList.get(i);
                        if (t.date.equals(yesterday)) {
                            System.out.println("Transaction ID: " + (i + 1) + ", Type: " + t.type + ", Amount: " + t.amount);
                            foundYesterday = true;
                        }
                    }
                    if (!foundYesterday) {
                        System.out.println("No transactions found for yesterday.");
                    }
                    break;
                case 3: // Total income
                    double totalIncome = 0.0;
                    for (Transaction t : transactionsList) {
                        if (t.type.equalsIgnoreCase("Sales")) {
                            totalIncome += t.amount;
                        }
                    }
                    System.out.println("Total Income from Sales: " + totalIncome);
                    break;
                case 4: // Print All
                    System.out.println("List of Transactions:");
                    for (int i = 0; i < transactionsList.size(); i++) {
                        Transaction t = transactionsList.get(i);
                        System.out.println("Transaction ID: " + (i + 1) + ", Details: " + t.type + ", " + t.amount + ", " + t.date);
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