package Module05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//  #4 
/*
    Author: Sergey Suhoff
    Date:   2022-04-17
    Purpose: To test the classes: Transaction, TransactionIO, ValidatorIO
*/
public class TestExpenseTracker {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String displayMenu = "MENU OPTIONS" + "\n  1. View Transactions" + "\n  2. Add Transactions"
                + "\n  3. View Expense" + "\n\nPlease choose an option: ";

        String continueProgram = "y";
        while (continueProgram.equalsIgnoreCase("y")) {

            // 1. Display a menu to the user and use the ValidatorIO static methods to
            // validate the users input (as shown in Figure 4.1 of the assignment).
            int input = ValidatorIO.getInt(scanner, displayMenu);

            // 2. If the user selects menu item one, display all the transactions in the
            // expenses.txt file. Invoke the findAll method from the TransactionIO class and
            // format the amount data field using $%,6.2.f
            if (input == 1) {
                System.out.println("MONTHLY EXPENSES");
            }

            // 3. If the user selects menu item 2, user to add a new transaction to the
            // expenses.txt file. Using ValidatorIO static methods for the user prompts.
            // this part reproduced from Figure 4.3 of the assignment
            else if (input == 2) {
                String c = "y";
                ArrayList<Transaction> transactions = new ArrayList<>();

                // 3-a. user to enter as many transactions as they wish by asking them to “Add
                // another transaction.” - need at least two while loops

                while (c.equalsIgnoreCase("y")) {
                    String description = ValidatorIO.getString(scanner, "\n  Enter the description: ");

                    double amount = ValidatorIO.getDouble(scanner, "  Enter the amount: ");

                    Transaction transaction = new Transaction(description, description, amount);

                    transactions.add(transaction);

                    c = ValidatorIO.getString(scanner, "\n  Add another transaction (y/n): ");
                }
                try {
                    TransactionIO.bulkInsert(transactions);
                } catch (IOException e) {
                    System.out.println("\n  Exception: " + e.getMessage());
                }
            }

            // 4. If the user selects menu item three, display the total expenses of all
            // transactions in the expenses.txt file. Invoke the findAll method from the
            // TransactionIO class and iterate over the list to get a running total of the
            // transaction amounts.
            else if (input == 3) {
                double amountTotal = 0;

                ArrayList<Transaction> transactions = TransactionIO.findAll();
                for (Transaction tran : transactions) {
                    amountTotal += tran.getAmount();
                }
                System.out.printf("\nYour total monthly expense is $%,6.2f\n", amountTotal);
            }

            // 5. Allow the user to stay in the menu by prompting them to continue or exit
            // the program
            continueProgram = ValidatorIO.getString(scanner, "\nContinue (y/n):  ");

            scanner.close();
        }

    }

}
