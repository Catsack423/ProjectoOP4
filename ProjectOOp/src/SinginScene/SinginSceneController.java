package SinginScene;

import java.net.URL;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

import ClassHelper.Alertmeassage;
import application.LoginSceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class SinginSceneController implements Initializable {
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

	private PreparedStatement prepar;
	private ResultSet result;
	private Statement statement;
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void CreatAccount(ActionEvent e) {
		//ปุ่มcreate account
		String username = UsernameTextFiled.getText();
		String password = PassTextFiled.getText();
		String repassword = RepasswordTextFiled.getText();
		Date date = new Date();

		if (username.isEmpty() && password.isEmpty()) { // ตรวจสอบว่าฟิลด์ว่างเปล่า
			ErorLabel.setVisible(true);
			ErorLabel.setText("Please enter username and password.");

			return;
		} else if (username.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
			// กรณีช้่องว่าง
			ErorLabel.setVisible(true);
			ErorLabel.setText("Do not leave it empty");

			return;
		} else if (password.length() < 8) { // รหัสน้อยกว่า8ตัว
			ErorLabel.setText("Password must be more 8 letters");
			ErorLabel.setVisible(true);
			return;
		} else if (!password.equals(repassword)) { // รหัสกับใส่รหัสไม่เหมือนกัน
			ErorLabel.setText("Please Enter same password " + password + "   " + repassword);
			ErorLabel.setVisible(true);
			return;

		} else {
			// check if username already used if not go to log in
			try {
				String checkUsernameString = "SELECT * FROM useraccount WHERE username = '" + username + "'";
				Connection connect = LoginSceneController.connectionDB();
				statement = connect.createStatement();
				result = statement.executeQuery(checkUsernameString);
				if (result.next()) {
					ErorLabel.setText("This username has been already used!!");
					ErorLabel.setVisible(true);
				} else {
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					String insertDataString = "INSERT INTO useraccount" + " (username,password,date) "
							+ "VALUES(?,?,?)";// ? ตัวแปรที่ตัองมาset code below
					prepar = connect.prepareStatement(insertDataString);
					prepar.setString(1, username);
					prepar.setString(2, password);
					prepar.setString(3, String.valueOf(sqlDate));
					prepar.executeUpdate();

					try {
						Alertmeassage alertmeassage = new Alertmeassage();
						alertmeassage.succesMessage("Create Account successful");
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/LoginScene.fxml"));
						root = loader.load();
						stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.setResizable(false);
						stage.show();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
	}

	public void ArrowbackClicked(ActionEvent e) {
		//ย้ายกลับไปหน้าlogin
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/LoginScene.fxml"));
			root = loader.load();
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();

		} catch (Exception e2) {
			// TODO: handle exception
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//เพิ่มปุ่มenterทไให้ใช้งานง่ายขึ้น
		RepasswordTextFiled.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				CreatAccount(new ActionEvent());
			}
		});

		UsernameTextFiled.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				CreatAccount(new ActionEvent());
			}
		});

		PassTextFiled.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				CreatAccount(new ActionEvent());
			}
		});

	}

}
