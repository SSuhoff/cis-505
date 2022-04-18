package Module05;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//  #3
/*
    Author: Sergey Suhoff
    Date:   2022-04-17
    Purpose: Class for read & write transactions to txt file
*/

public class TransactionIO {
    // 1. A private string constant data field named FILE_NAME. The default value is
    // “expenses.txt”
    private static final String FILE_NAME = "expenses.txt";

    // 2. A private File data field name file. The default value is a new File
    // instance. Use the FILE_NAME constant as the argument for the new file
    // instance.
    private static File file = new File(FILE_NAME);

    // 3. A public static method bulkInsert with an ArrayList<Transaction>
    // In the body of the function, create a new PrintWriter variable named output
    // and set the default value to null. Using an if…else statement, check if the
    // file exists.
    // ... - method below reproducing provided in assignment Figure 3.3
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {

        PrintWriter output = null;
        // if - checking existence of file & create it using file_name.
        if (file.exists()) {
            // Creating a file output stream
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
        } else {
            // referring to existing file
            output = new PrintWriter(FILE_NAME);
        }

        for (Transaction tran : transactions)
        // each transaction is written to the file
        {
            output.print(tran.getDate() + " ");
            output.print(tran.getDescription() + " ");
            output.println(tran.getAmount());
        }
        output.close();
    }

    // 4. A public static method findAll with a return type of
    // ArrayList<Transaction>. Give the signature of this method a “throws
    // IOException.”
    public static ArrayList<Transaction> findAll() throws IOException {

        ArrayList<Transaction> transactions = null;
        if (file.exists()) {
            // In the body of the method, open the expenses.txt file,
            Scanner input = new Scanner(new File(FILE_NAME));

            transactions = new ArrayList<Transaction>();

            while (input.hasNext()) {
                transactions.add(new Transaction());
            }

        } else {

            // returning an ArrayList of transactions
            return new ArrayList<>();
        }
        return transactions;
    }

    public static Object getAmount() {
        return null;
    }

}