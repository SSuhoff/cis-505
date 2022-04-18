package Module05;

//  #1
/*
    Author: Sergey Suhoff
    Date:   2022-04-17
    Purpose: Class to represent an expense transaction
*/
public class Transaction {

    // 1. A private string data field named date that specifies the date of a
    // transaction. The default value is today’s date formatted as “MM-dd-yyyy”
    private String date = "MM-dd-yyyy";

    // 2. A private string data field named description that specifies the
    // description of a transaction. The default is an empty string.
    private String description = "";

    // 3. A private double data field named amount of a transaction.
    // The default value is 0.
    private double amount = 0;

    // 4. Accessor and mutator methods for the all three data fields.
    // 4-a. getters
    public String getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }

    public double getAmount() {
        return this.amount;
    }

    // 4-a. setters
    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // 5. A no-argument constructor that creates a default transaction.
    public Transaction() {

    }

    // 6. An argument constructor that creates a transaction using the three data
    // fields.
    public Transaction(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    // 7. Override the toString method. Return a string description of a transaction
    // with all three data fields, on separate lines.
    @Override
    public String toString() {
        return "\nDate: " + getDate() + "\nDescription: " + getDescription() + "\nAmount: $%,6.2f\n";
    }

}
