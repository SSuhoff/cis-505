/*
References: Sergey Suhoff
Date:       2022-05-29
Purpose:    Assignment Module 11
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/
public class Student {
    private String tfFirstName = "";
    private String tfLastName = "";
    private String tfCourseName = "";
    private String grade = "";

    // Default constructor
    Student() {
    }

    // Parameterized constructor
    Student(String tfFirstName, String tfLastName, String tfCourseName, String grade) {
        this.tfFirstName = tfFirstName;
        this.tfLastName = tfLastName;
        this.tfCourseName = tfCourseName;
        this.grade = grade;
    }

    // Overriding toString to set values
    @Override
    public String toString() {
        return "Student First Name: " + getTfFirstName()
                + "Last Name: " + getTfLastName()
                + "Course completed: " + getTfCourseName()
                + "Course grade: " + getGrade() + "\n";
    }

    // Getters - firstName, lastName, course, grade
    public String getTfFirstName() {
        return tfFirstName;
    }

    public String getTfLastName() {
        return tfLastName;
    }

    public String getTfCourseName() {
        return tfCourseName;
    }

    public String getGrade() {
        return grade;
    }

    // Setters - firstName, lastName, course, grade
    public void setTfFirstName(String tfFirstName) {
        this.tfFirstName = tfFirstName;
    }

    public void setTfLastName(String tfLastName) {
        this.tfLastName = tfLastName;
    }

    public void setTfCourseName(String tfCourseName) {
        this.tfCourseName = tfCourseName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
