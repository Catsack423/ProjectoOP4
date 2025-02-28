package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
			//FXMLLoader loader = new FXMLLoader(getClass().getResource("/Homescreen/homescreen.fxml"));
			Parent root = loader.load();
			primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Login Page");
            primaryStage.setResizable(false);
            primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
