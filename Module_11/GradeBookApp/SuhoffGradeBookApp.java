/*
References: Sergey Suhoff
Date:       2022-05-29
Purpose:    Assignment Module 11
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// import java.text.DecimalFormat;
import javafx.geometry.Insets;

public class SuhoffGradeBookApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("OpenEdX Gradebook App");
        GridPane gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(5);

        // create labels
        Label lblFirstName = new Label("Student's First Name: ");
        Label lblLastName = new Label("Student's Last Name: ");
        Label lblCourseName = new Label("Course they completed: ");
        Label lblGrade = new Label("Student's course grade: ");
        // end labels

        // start setup form controls
        TextField tfFirstName = new TextField();
        TextField tfLastName = new TextField();
        TextField tfCourseName = new TextField();
        // end textfields

        ComboBox<String> cboBoxGrades = new ComboBox<String>();
        List<String> gradesList = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "F"));
        cboBoxGrades.getItems().addAll(gradesList);

        // adding buttons ------------
        Button btnClear = new Button("Clear");
        Button btnSave = new Button("Save");
        Button btnView = new Button("View");
        Button btnHelp = new Button("Help");
        // end buttons
        // end setup form controls

        // start setup gridpane
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gp.setHgap(5.5);
        gp.setVgap(5.5);

        // add controls to gridpane
        gp.add(lblFirstName, 1, 1);
        gp.add(tfFirstName, 2, 1);
        // end first row of grid

        gp.add(lblLastName, 1, 2);
        gp.add(tfLastName, 2, 2);
        // end second row of grid

        gp.add(lblCourseName, 1, 3);
        gp.add(tfCourseName, 2, 3);
        // end third row of grid

        gp.add(lblGrade, 1, 4);
        gp.add(cboBoxGrades, 2, 4);
        // end fourth row of grid

        gp.add(btnClear, 1, 5);
        gp.add(btnSave, 2, 5);
        // end fifth row of grid

        gp.add(btnView, 1, 6);
        gp.add(btnHelp, 2, 6);
        // end sixth row of grid
        // end add controls to gridpane
        // end setup gridpane

        Scene myScene = new Scene(gp);// set gridpane to scene
        primaryStage.setScene(myScene);
        primaryStage.show();

        // Buttons event handlers
        btnClear.setOnAction(ev -> clearForm());
        btnSave.setOnAction(ev -> {
            try {
                writeToFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        btnView.setOnAction(ev -> {
            try {
                viewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btnHelp.setOnAction(ev -> viewHelp("help.txt"));

    }

    // Main method to launch app
    public static void main(String[] args) {
        Application.launch(args);
    }

    Labeled tfFirstName;
    ComboBox<String> cboBoxGrades;
    Labeled tfLastName;
    Labeled tfCourseName;
    Labeled tResults;

    // to clear form fields
    private void clearForm() {
        tfFirstName.setText("");
        tfLastName.setText("");
        tfCourseName.setText("");
        cboBoxGrades.setValue("");
    }

    private File file = new File("grades.txt");

    // Method to make grades.txt file
    public class CreateFile {

        public static void main(String[] args) {
            try {
                File myObj = new File("grades.txt");
                if (myObj.createNewFile()) {
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    // to save data to file or create new if file doesn't exist't
    private void writeToFile() throws IOException {
        // Checking if all fields filled
        if (!tfFirstName.getText().isEmpty()) {
            String name = tfFirstName.getText();
            String lname = tfLastName.getText();
            String newLine = "\n" + name + "," + lname + "," + tfCourseName.getText() + "," + cboBoxGrades.getValue();
            // check if the file exist and not blank
            if (file.length() != 0) {
                try (FileWriter writer = new FileWriter(file, true);) {
                    writer.write(newLine);
                    writer.close();
                }

                // create new file if file doesn't exists, if blank,- adding entered data
            } else {
                file.createNewFile();
                FileWriter writer = new FileWriter(file, true);
                writer.write("Student First Name, Last Name, Course Name, Grade" + "\n");
                writer.close();

            }
        }

    }

    // Method to view help.txt file
    private Object viewHelp(String string) {
        return null;
    }

    // Method to write and return students info from txt file
    private ArrayList<Student> getStudent() throws IOException {
        String line;
        FileReader reader = new FileReader(file);
        BufferedReader buffReader = new BufferedReader(reader);
        ArrayList<Student> studentArray = new ArrayList<Student>();
        String[] lineArray;

        buffReader.readLine();

        while ((line = buffReader.readLine()) != null) {
            lineArray = line.split(",");
            Student tempStudent = new Student(lineArray[0], lineArray[1], lineArray[2], lineArray[3]);
            studentArray.add(tempStudent);
        }
        buffReader.close();
        return studentArray;
    }

    // this method to view results - students data from txt file
    private void viewFile() throws IOException {
        if (file.exists()) {
            // Check if file exist
            ArrayList<Student> student = getStudent();
            String results = "";
            for (int i = 0; i < student.size(); i++) {
                results += student.get(i).toString() + "\n";
            }
            tResults.setText(results);
        }
    }
}
