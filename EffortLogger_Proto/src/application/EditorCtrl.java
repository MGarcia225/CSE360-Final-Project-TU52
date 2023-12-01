package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class EditorCtrl implements Initializable{

    @FXML
    private Label uid; // Label for displaying a unique ID

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	uid.setText("ID: " + User.user.getUserID()
    				+ "\nUsername: " + User.user.getUsername()
    				+ "\nHello " + User.user.getFirstName() + " " + User.user.getLastName() + "!");
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