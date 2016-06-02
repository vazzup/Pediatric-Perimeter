package com.lvpei.pediperi;

import com.lvpei.pediperi.isopter.Isopter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PediPeri extends Application{
	
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Pediatric Perimeter");
		
		HBox outerHBox = new HBox();
		
		outerHBox.getChildren().add(new Canvas(700, 700));
		
		VBox outerVBox = new VBox();
		outerHBox.getChildren().add(outerVBox);
		
		Isopter isopter = new Isopter();
		outerVBox.getChildren().add(isopter);
		
		Scene scene = new Scene(outerHBox, 1280, 720);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
}
