package Module05;

import java.util.Scanner;

//  #2
/*
    Author: Sergey Suhoff
    Date:   2022-04-17
    Purpose: Class to validate invalid user entries
*/

public class ValidatorIO {

    // 1. A static method getInt with a Scanner argument sc and a string
    // argument named prompt and an Integer return type.
    // ... - method below reproducing provided by assignment Figure 2.1
    public static int getInt(Scanner sc, String prompt) {
        // ... - method here reproducing provided by assignment Figure 2.1
        int input = 0;

        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);

            if (sc.hasNextInt()) {
                input = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("\n  Error! Invalid integer value.\n");
            }
            sc.nextLine();
        }
        return input;
    }

    // 2. A static method getDouble with a Scanner argument named sc and a
    // string argument named prompt and a double return type.

    // 2-a. Repeat the process similar to Figure 2.1, but this time check for double
    // values by using sc.hasNextDouble() and sc.nextDouble()).
    public static double getDouble(Scanner sc, String prompt) {
        double input = 0;

        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);

            if (sc.hasNextDouble()) {
                input = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("\n  Error! Invalid double value.\n");
            }
            sc.nextLine();
        }
        return input;
    }

    // 3. A static method getString with a Scanner argument named sc and a
    // string argument named prompt and a string return type. Display the prompt
    // message and use sc.next() to capture the user’s inputted value. Return the
    // inputted value.
    public static String getString(Scanner sc, String prompt) {
        String input = "";

        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);

            if (sc.hasNext()) {
                input = sc.next();
                isValid = true;
            } else {
                System.out.println("\n  Error! Invalid string value.\n");
            }
            sc.nextLine();
        }
        return input;
    }
}
