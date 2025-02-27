module ProjectOOp {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
<<<<<<< Updated upstream
=======
	requires java.desktop;
>>>>>>> Stashed changes
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	opens SinginScene to javafx.graphics, javafx.fxml;
	opens HelperClass to javafx.graphics, javafx.fxml;
}
