package com.lvpei.pediperi.form;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Form extends Application {

	public static void main(String args[]) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		//Title of window
		primaryStage.setTitle("Patient Details");
		
		//Using grid layout
		GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
		
        //Pediatric Perimeter Text
		Text welcomeText = new Text("Pediatric Perimeter");
		welcomeText.setId("welcome-text");
		gridPane.add(welcomeText, 0, 0, 2, 2);
		
		//Patient Name Label
		Label patientName = new Label("Patient Name:");
		gridPane.add(patientName, 0, 2);
		
		//TODO Patient 
		//TODO d.o.b
		
		//Patient Age ScrollDown
		//TODO Patient Sex Radio Button
		
		//Scene
		Scene scene = new Scene(gridPane, 500, 300);
		scene.getStylesheets().add(Form.class.getResource("Form.css").toExternalForm());
		
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}

}
