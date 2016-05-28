package com.lvpei.pediperi;

import com.lvpei.pediperi.isopter.Isopter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PediPeri extends Application{
	
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Pediatric Perimeter");
		
		//BorderPane borderPane = new BorderPane();
		Isopter isopter = new Isopter();
		isopter.addReading(0,  60);
		//isopter.dodo();
		//borderPane.setRight(isopter);
		Scene scene = new Scene(isopter, 500, 500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
}
