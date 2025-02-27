package SinginScene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SinginSceneController {
	@FXML
    private Button ArrowbackButton;

    @FXML
    private Button CreatAccountButton;

    @FXML
    private Label ErorLabel;

    @FXML
    private PasswordField PassTextFiled;

    @FXML
    private PasswordField RepasswordTextFiled;

    @FXML
    private TextField UsernameTextFiled;
    
    
    
    
    public void CreatAccount() {
    	String username = UsernameTextFiled.getText();
    	String password= PassTextFiled.getText();
    	String repassword = RepasswordTextFiled.getText();
    	
    	if (username.isEmpty() && password.isEmpty()) { // ตรวจสอบว่าฟิลด์ว่างเปล่า
	    	ErorLabel.setVisible(true);
	    	ErorLabel.setText("Please enter username and password.");
	    	
	        return;
	    }else if(username.isEmpty() || password.isEmpty()|| repassword.isEmpty()) {
    		// กรณีช้่องว่าง
	    	ErorLabel.setVisible(true);
    		ErorLabel.setText("Do not leave it empty");
  
    		return;
    	} 
	    else if(password.length()< 8 ) { //รหัสน้อยกว่า8ตัว
    		ErorLabel.setText("Password must be more 8 letters");
    		ErorLabel.setVisible(true);
    		return;
    	}else if(password!=repassword) { //รหัสกับใส่รหัสไม่เหมือนกัน
    		ErorLabel.setText("Please Enter same password");
    		ErorLabel.setVisible(true);
    		return;
    	}
    	
    	
    	
	}
}
