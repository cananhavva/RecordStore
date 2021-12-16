package com.canan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainTest extends Application {
	public static Stage primaryStage;
	
	public static void main(String... args) {
		
		launch(args);
		
	}
	
	@Override
	public void start(Stage primary) throws Exception {
		try {
			MainTest.primaryStage = primary;
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("view/login/LoginView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("view/main/application.css").toExternalForm());
			primary.setScene(scene);
			primary.alwaysOnTopProperty();
			primary.centerOnScreen();
			primary.initStyle(StageStyle.DECORATED);
			primary.setResizable(false);
			primary.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getPrimaryStage() {
		return MainTest.primaryStage;
	}
}