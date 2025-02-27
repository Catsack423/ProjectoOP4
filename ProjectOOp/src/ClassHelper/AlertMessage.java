package ClassHelper;

import java.security.KeyStore.PrivateKeyEntry;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertMessage {
	private Alert alert;
	
	public void erorMessage(String mess) {
		alert = new Alert(AlertType.ERROR);
		alert.setTitle("Eror Message");
		alert.setHeaderText(null);
		alert.setContentText(mess);
		alert.showAndWait();
		
	}
	
	public void successsMessage(String mess) {
		alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Message");
		alert.setHeaderText(null);
		alert.setContentText(mess);
		alert.showAndWait();
	}
}
