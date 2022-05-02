
/*
    Author:     Sergey Suhoff
    Date:       2022-05-01
    Purpose:    Assignment 7.2
*/
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// Extend the JavaFX Application object and setup the @Override start method with a single argument for the Stage object. 
public class SuhoffFutureValueApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // A. Create private variables for
    // A.1 two TextField’s
    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate = new TextField();
    // A.2 one TextArea,
    private TextArea txtArea = new TextArea();
    // A.3 five Labels.
    // (a) Set the text for the labels to match the labels in Exhibit.
    private Label lblMonthlyPayment = new Label("Monthly Payment:"); // per Exhibit
    private Label lblInterestRate = new Label("Interest Rate:"); // per Exhibit
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    private Label lblYears = new Label("Years: ");
    private Label lblOutputDate = new Label("");
    // A.4 one ComboBox of type Integer,
    private ComboBox<Integer> ddlYears = new ComboBox<Integer>();
    // A.5 two Button’s.
    private Button btnCalculate = new Button("Calculate"); // per Exhibit
    private Button btnClear = new Button("Clear");

    @Override
    public void start(Stage primaryStage) { // per Exhibit

        // (b) Set the text for the buttons to match the buttons in Exhibit
        // (c) In the start() method, add a new GridPane object and set its alignment to
        // Pos.CENTER, set its padding to 11.5, 12.5, 13.5, and 14.5. Next, set the
        // panes Hgap to 5.5 and its Vgap to 5.5.
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // (d) Add the controls to the GridPane. For the lblInterestRateFormat label,
        // set the text fill to red and HPos to the right
        lblInterestRateFormat.setTextFill(Color.RED); // per Exhibit
        pane.add(lblInterestRateFormat, 1, 2); // per Exhibit
        pane.add(txtMonthlyPayment, 1, 0);
        pane.add(txtInterestRate, 1, 1);
        pane.add(txtArea, 0, 7, 2, 1);

        pane.add(lblYears, 0, 3);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT); // per Exhibit

        // (e) Add the clear and calculate buttons to an HBox with a spacing of 10 and a
        // padding of 15, 0, 15, and 30.
        HBox actionBtnContainer = new HBox(); // per Exhibit
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30)); // per Exhibit
        actionBtnContainer.setSpacing(10); // per Exhibit
        actionBtnContainer.getChildren().add(btnClear); // per Exhibit
        actionBtnContainer.getChildren().add(btnCalculate); // per Exhibit
        pane.add(actionBtnContainer, 1, 4); // per Exhibit

        // (f) Set the primary stages title to “YourLastName Future Value App.”
        Scene scene = new Scene(pane, 400, 450);
        primaryStage.setTitle("Suhoff Future Value App");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}