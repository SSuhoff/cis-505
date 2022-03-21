/*
    Author: Sergey Suhoff
    Date: May 20, 2022
    Purpose: Create fan objects and output the results 
*/

public class TestFanApp {    // main method
    public static void main(String[] args) {
        //instantiate two instances of the fan object in the fan class
        //fan1 uses default constructor
        Fan fan1 = new Fan();

        //fan2 uses overloaded constructor
        Fan fan2 = new Fan();
        fan2.setSpeed(2);
		fan2.isOn(true);
		fan2.setRadius(8);
		fan2.setColor("Blue");

        //output custom overridden toString method - this is actually how you do it
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
