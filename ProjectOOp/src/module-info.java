module ProjectOOp {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;

	requires java.desktop;

	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	opens SinginScene to javafx.graphics, javafx.fxml;
	opens ClassHelper to javafx.graphics,javafx.fxml;
	opens Homescreen to javafx.graphics,javafx.fxml;
}
