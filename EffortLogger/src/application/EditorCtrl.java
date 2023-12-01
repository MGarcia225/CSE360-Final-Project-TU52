package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class EditorCtrl implements Initializable{

    @FXML
    private Label uid; // Label for displaying a unique ID
    public ComboBox<String> project;
    @FXML
    public ComboBox<String> effortentry;
    @FXML
    public ComboBox<String> lifecycle;
    @FXML
    public ComboBox<String> effortcat1;
    @FXML
    public ComboBox<String> plan;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	uid.setText("ID: " + User.user.getUserID()
    				+ "\nUsername: " + User.user.getUsername()
    				+ "\nHello " + User.user.getFirstName() + " " + User.user.getLastName() + "!");
    	project.getItems().addAll(
                "Notifications",
                "Encryption For Authentication",
                "Tooltip UI Element");
    	effortentry.getItems().addAll(
                "Effort 1",
                "Effort 2",
                "Effort 3");
    	lifecycle.getItems().addAll(
                "requirements",
                "planning poker",
                "sprint");
    	effortcat1.getItems().addAll(
                "11/11/2023",
                "11/15/2023",
                "11/20/2023");
    	plan.getItems().addAll(
                "Test the feature",
                "Playing planning poker",
                "Push feature to github");
    }
    public void Main(ActionEvent event) {
        Platform.exit();
    }
    public void gotoConsole(ActionEvent event) throws Exception {
    	if (User.user.getClearance() == 0)
    			SceneController.controller.switchTo(event, "Console");
    	else if (User.user.getClearance() == 1)
    		SceneController.controller.switchTo(event, "AdminConsole");
    }
}