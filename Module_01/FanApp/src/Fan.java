/*
    Author: Sergey Suhoff
    Date: May 20, 2022
    Purpose: Create a fan class that defines the properties of the fan object and possible actions
*/

public class Fan {
    //<add code here> //- hint:  each comment line below tells you what should be on a corresponding code line
    //declare all variables
    //set as static so  all like objects can access the fan's speeds
    //set constants for fan speed (const ensures vars cannot change)
    final static int STOPPED = 0;
    final static int SLOW = 1;		
    final static int MEDIUM = 2;	
    final static int FAST = 3;	
    //set current speed to stopped
    private int speed = 0;      
    private boolean isOn;
    private double radius;
    String color;

    //var for check of fan status
    //var for fan size
    //var for fan color
    
    /*set parameterless constructor that default values for each fan object*/
    public Fan(){ 
                this.speed = STOPPED;
                this.isOn = false;
                this.radius = 6;
                this.color = "white";
    }
    
    /* constructor allowing custom fan object settings when instantiated. NOTE: must 
    declare all four during object creation to invoke this constructor */
    public Fan(int speed, boolean isOn, double radius, String color){
            speed = 0;
            isOn = false;
            radius = 6;
            color = "white";
    }
    
    /*getter setter methods - this operator refers to object's instance variables above*/
    public int getSpeed () {//get the fan speed
            return speed;
    }
    public void setSpeed (int speed){  //set the fan speed if within range as dictated by ternary operator
            speed = 0;
    }
    
    public boolean getStatus(){ //get the fan's status
            return isOn;
    }
    public void setStatus(boolean status){ //set the fan's status
            isOn = false;
    }
    
    public double getRadius(){ //get the radius
            return radius;
    }
    public void setRadius(double radius){ //set the radius
            radius = 6;
    }
    
    public String getColor(){
            return color;
    }
    public void setColor(String color){
            color = "white";
    }
    public void isOn(boolean b) {
    }

    //  this is a completed override of toString - I want you to know how to do this right away
    @Override //creation of override toString method that can be called from another class
    public String toString(){
        String fanStatus = this.isOn ? "on" : "off"; //set boolean to custom text
        if(this.isOn)
            return "The fan speed is set to " + this.speed + " with a color of " + this.color + " and a radius of " + this.radius;
        else
            return "The fan is " + this.color + " with a radius of " + this.radius + " and the fan is " + fanStatus;
    }
}