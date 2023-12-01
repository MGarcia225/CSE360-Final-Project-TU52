package application;

import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {	
	private static HashMap<String, String> scenePaths = new HashMap<>();
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public static SceneController controller;
	
	public void open(String newScene) throws Exception {
		root = FXMLLoader.load(getClass().getResource(scenePaths.get(newScene)));
    	stage = new Stage();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void switchTo(ActionEvent event, String newScene) throws IOException {
		root = FXMLLoader.load(getClass().getResource(scenePaths.get(newScene)));
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	static {
		scenePaths.put("Console", "/application/Effort_Logger_Console.fxml");
		scenePaths.put("AdminConsole", "/application/Effort_Logger_Admin_Console.fxml");
		scenePaths.put("Editor", "/application/Effort_Logger_Editing.fxml");
		scenePaths.put("Security", "/application/Security.fxml");
	}
}
