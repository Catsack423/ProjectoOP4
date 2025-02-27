package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
    
    private Connection connect;
    private PreparedStatement prepar;
    private ResultSet result;
    private Statement statement;
    private Stage stage;
	private Scene scene;
	private Parent root;

    
    
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
    
    
    public static Connection connectionDB() {
    	String URL = "jdbc:mysql://localhost:3306/maketapp";
        String USER = "root";
        String PASSWORD = "kimbap001";
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection connect = DriverManager.getConnection(URL,USER,PASSWORD);
    		return connect;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    
    
    public void login() {
    	
    }
    
    
    
  
    public void creataccountclicked(ActionEvent e) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SinginScene/SinginScene.fxml"));
    	    root = loader.load();
    	    stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
    	    scene = new Scene(root);
    	    stage.setScene(scene);
    	    stage.show();
		} catch (Exception e2) {
			e2.printStackTrace();
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