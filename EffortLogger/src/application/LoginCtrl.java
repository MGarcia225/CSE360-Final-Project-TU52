package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button; 
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.Random;

public class LoginCtrl {
	@FXML
	private Label lblstat;
	@FXML
	private TextField userN;
	@FXML
	private TextField passW;
	@FXML
	private Button signOut;	
	@FXML
	private Label securityTxt;
	@FXML
	private TextField secOde;
	
	private static String securityCode = "100";
	
	private static User user;
	private int clearance;

	private static String adminfx = "/application/pAdmin.fxml";
	private static String securityfx = "/application/Security.fxml";
	
	public void Login(ActionEvent event) throws Exception {
		user = User.findUser(userN.getText());
		
		//Parent root = null;
		boolean correctCredentials = false;
		
		if (user != null) {
			correctCredentials = user.checkCredentials(passW.getText());
			
			if (correctCredentials) {
				clearance = user.getClearance();
				user.login();
				
				if (clearance == 0) {
					SceneController.controller.open("Console");
					//root = FXMLLoader.load(getClass().getResource(mainfx));
				}
				else if (clearance == 1) {
					SceneController.controller.open("AdminConsole");
					//root = FXMLLoader.load(getClass().getResource(adminfx));
				}
			}
			else {
				lblstat.setText("Login Failed");
				SceneController.controller.open("Security");
				//root = FXMLLoader.load(getClass().getResource(securityfx));
			}
			System.out.println(user.getFirstName());
		}
		else {
			lblstat.setText("Login Failed");
			SceneController.controller.open("Security");
			//root = FXMLLoader.load(getClass().getResource(securityfx));
		}
		
		/*
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		*/
		
		if (user != null && !correctCredentials) {
			Random rand = new Random();
			securityCode = Integer.toString(rand.nextInt(1000));
			SendEmail.send(user.getPhoneData(), "Security Code", securityCode);
		}
	}
	
	public void Security(ActionEvent event) throws Exception {
		if(secOde.getText().equals(securityCode)) {
			user.login();

			SceneController.controller.open("Console");
			/*
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource(mainfx));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			*/
		}
		else {
			securityTxt.setText("Try again");
		}
	}
}