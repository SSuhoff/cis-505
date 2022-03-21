/*
    Author: Sergey Suhoff
    Date: May 20, 2022
    Purpose: Create fan objects and output the results 
*/

public class TestFanApp {    // main method
    public static void main(String[] args) {
        //instantiate two instances of the fan object in the fan class
        //fan1 uses default constructor
        //fan2 uses overloaded constructor

        //output custom overridden toString method - this is actually how you do it
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
