package com.canan;

import java.io.IOException;

import org.hibernate.annotations.Parent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RecordDatabaseManager extends Application {
	private static Scene scene;
	
	public static void main(String... args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		scene = new Scene((javafx.scene.Parent) loadFXML("view/login/LoginView"));
		stage.setScene(scene);
		stage.show();
	}
	
	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(RecordDatabaseManager.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}
	
	public static void setRoot(String fxml) throws IOException {
		scene.setRoot((javafx.scene.Parent) loadFXML(fxml));
	}
}