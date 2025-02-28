package Homescreen;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomescreenController implements Initializable {
    @FXML
    private ImageView logoutImage;

    @FXML
    private Label logoutLabel;
    
    @FXML
    private Label usernamelabel;
    
    
    private String username= "Username";
    private Stage stage;
	private Scene scene;
	private Parent root;

    
    


	
	
	public void logouticongetClicked(MouseEvent e) {
		System.out.println("HEllo world");
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/LoginScene.fxml"));
			root = loader.load();
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.show();

		} catch (Exception e2) {
			// TODO: handle exception
		}

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	
	public void showandsetUsername(String username) {
		this.username=username;
		usernamelabel.setText(this.username);
		
	}
	
    
}
