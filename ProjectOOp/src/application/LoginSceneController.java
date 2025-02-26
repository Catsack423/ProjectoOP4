package application;



import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginSceneController {
    @FXML
    private AnchorPane AnchorLogin;

    @FXML
    private Button CreateAccountButton;

    @FXML
    private PasswordField PassTextFiled;

    @FXML
    private TextField UsernameTextFiled;

    @FXML
    private Button loginButton;
    
    @FXML
    private Label ErorLabel;
    
    
    
    public void LoginButtonClick(ActionEvent e) {
    	
    	String username = UsernameTextFiled.getText();
    	String password= PassTextFiled.getText();
    	
    	if (username.isEmpty() || password.isEmpty()) { // ตรวจสอบว่าฟิลด์ว่างเปล่า
	    	ErorLabel.setVisible(true);
	    	ErorLabel.setText("Please enter username and password.");
	    	delay2second(2);
	        return;
	    }else if(username.isEmpty() || password.isEmpty()) {
    		ErorLabel.setVisible(true);
    		ErorLabel.setText("Do not leave it emthy");
    		delay2second(2);
    		return;
    	} 	
    	
    	
    }
    
    
    
    
    
    
    
    
    void delay2second(int time) {
    	Timer timer = new Timer();
    	timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	ErorLabel.setVisible(false);
                timer.cancel(); // ปิด Timer เมื่อทำงานเสร็จ
            }
        }, time*1000);
    }
    
    
    
    
}