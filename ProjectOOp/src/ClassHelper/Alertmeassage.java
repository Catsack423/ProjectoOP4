package ClassHelper;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alertmeassage {
	Alert alert;
	
	public void errorMessage(String mess) {
		alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Message");
		alert.setHeaderText(null);
		alert.setContentText(mess);
		alert.showAndWait();
		
		
	}
	
	
	public void succesMessage(String mess) {
		alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Message");
		alert.setHeaderText(null);
		alert.setContentText(mess);
		alert.showAndWait();
		
		
	}
}
