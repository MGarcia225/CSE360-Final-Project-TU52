package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainCtrl implements Initializable {

    @FXML
    private Label uid; // Label for displaying a unique ID
    @FXML
    public ComboBox<String> project;
    @FXML
    public ComboBox<String> lifecycle;
    @FXML
    public ComboBox<String> effortcat1;
    @FXML
    public ComboBox<String> effortcat2;
    @FXML
    public Button start;
    @FXML
    public Button stop;
    @FXML
    public Label clock;
    
    static public boolean active = false;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	uid.setText("ID: " + User.user.getUserID()
    				+ "\nUsername: " + User.user.getUsername()
    				+ "\nHello " + User.user.getFirstName() + " " + User.user.getLastName() + "!");
    	project.getItems().addAll(
                "Notifications",
                "Encryption For Authentication",
                "Tooltip UI Element");
    	lifecycle.getItems().addAll(
                "requirements",
                "planning poker",
                "sprint");
    	effortcat1.getItems().addAll(
                "11/11/2023",
                "11/15/2023",
                "11/20/2023");
    	effortcat2.getItems().addAll(
                "Test the feature",
                "Playing planning poker",
                "Push feature to github");
    	if (active) {
    		startActivity();
    	} else {
    		stopActivity();
    	}
    	
    	System.out.println(active);
    }
    public void Main(ActionEvent event) {
        Platform.exit();
    }
    public void gotoEditor(ActionEvent event) throws Exception {
    	SceneController.controller.switchTo(event, "Editor");
    }
    public void startActivity() {
    	clock.setStyle("-fx-background-color:green");
    	clock.setText("Clock has Started");
    	active = true;
    	
    }
    public void stopActivity() {
    	clock.setStyle("-fx-background-color:red");
    	clock.setText("Clock is Stopped");
    	active = false;
    }
}