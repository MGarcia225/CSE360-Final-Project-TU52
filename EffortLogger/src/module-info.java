module Phase4Proto {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.mail;
	
	opens application to javafx.graphics, javafx.fxml;
}
