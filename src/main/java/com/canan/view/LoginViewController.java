package com.canan.view;

import java.awt.TextField;

import com.canan.RecordDatabaseManager;
import com.canan.entity.LoginEntity;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

public class LoginViewController {
	@FXML
	private TextField fldUserName;
	@FXML
	private PasswordField fldUserPassword;
	
	@FXML
	private Button btnCancel;
	
	@FXML
	private Button btnCommit;
	
	@FXML
	void cancelAction(MouseEvent event) {
		System.exit(0);
	}
	
	@FXML
	void commitAction(MouseEvent event) {
		String userName = fldUserName.getText();
		String password = fldUserPassword.textProperty().get();
		
		LoginEntity loginUser = new LoginEntity(0, userName, password, password);
		if (!loginUser.canLogin(loginUser)) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Hata!");
			alert.setHeaderText("Kullan�c� ad� veya �ifre yanl��");
			// alert.setContentText("Kullan�c� ad� veya �ifre yanl��");
			alert.show();
			
			fldUserPassword.clear();
		} else {
			try {
				RecordDatabaseManager.setRoot("view/main/MainView");
			} catch (Exception ex) {
				// TODO: handle exception
			}
			// BorderPane root;
			// try {
			//
			// root = (BorderPane)
			// FXMLLoader.load(getClass().getResource("../../view/main/MainView.fxml"));
			// Scene scene = new Scene(root);
			// scene.getStylesheets().add(getClass().getResource("../../view/main/application.css").toExternalForm());
			// MainTest.getPrimaryStage().setScene(scene);
			// MainTest.getPrimaryStage().show();
			// }
			// catch (IOException ex) {
			// ex.printStackTrace();
			// }
		}
	}
}