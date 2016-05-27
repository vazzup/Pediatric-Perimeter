package com.lvpei.pediperi.isopter;

import java.util.Vector;

import com.lvpei.pediperi.isopter.linebutton.LineButton;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

public class Isopter extends StackPane{
	
	/**
	 * @author Vatsal Kanakiya
	 * @version 1.0
	 * @since 2016-05-25
	 * Isopter Class, basically a StackPane to implement Isopter
	 * Canvas contains circles,has lowest z-index value
	 * meridians is a vector of all meridians, created using LineButtons
	 * functions are self explanatory;
	 * Note: the x - offset for rotate is half the width of the LineButton
	 * Example: Rotate(45*i, 1.5, 0);
	 */
	
	private int set = 0; //meridian number which has been set
	int diameter = 200, canvasSide = 250;  //diameter of rim and size of canvas
	Canvas canvas;
	Vector <LineButton> meridians;
	public Isopter() {
		/*
		 * Default Constructor
		 */
		
		//Vector of all buttons. 
		//0th element is 180 degree button, and they move in a clockwise direction
		meridians = new Vector<LineButton>();
		
		//Canvas for Circles, draw circles, and add circles to layout
		//Notice, since canvas is added first, it'll have lowest z value
		canvas = new Canvas(canvasSide, canvasSide);
		this.drawCircles(diameter);
		this.getChildren().add(canvas);
		
		//Create inner labels
		this.createInnerTexts();
		
		//Create meridian LineButtons and add to layout
		this.buildMeridians();
		
		//Define onMouseClicked Functions for all LineButtons
		//TODO add the arduino communication code to these functions
		this.defineMouseClicks();
		
		//Add StyleSheet for Texts
		this.getStylesheets().add(Isopter.class.getResource("Isopter.css").toExternalForm());
		
	}
	
	private void drawCircles(int diameter) {
		
		/*
		 * Function to draw circles in canvas.
		 * setLineWidth changes thickness to 3
		 * Stroke color is changed so that only outermost (rim) circle,
		 * and the innermost (daisy) circle are darkened.
		 * a in rgba represents alpha value, i.e, opacity
		 * Range: r, g, b - [0, 255]; a - [0, 1]; r, b, b, a belong to Double
		 * TODO involve diameter into calculations
		 * TODO fix circle dimensions as per previous code by @derbedhruv
		 */
		
		GraphicsContext graphicsContext = this.canvas.getGraphicsContext2D();
		graphicsContext.setLineWidth(3);
		graphicsContext.setStroke(Color.BLACK);
		graphicsContext.strokeOval(80, 80, 340, 340);
		graphicsContext.setStroke(Color.rgb(0, 0, 0, 0.25));
		graphicsContext.strokeOval(90, 90, 320, 320);
		graphicsContext.strokeOval(110, 110, 280, 280);
		graphicsContext.strokeOval(145, 145, 210, 210);
		graphicsContext.setStroke(Color.BLACK);
		graphicsContext.strokeOval(190, 190, 120, 120);
	}
	
	private void buildMeridians() {
		/*
		 *Function to create and add meridians to isopter
		 *meridians are LineButtons
		 *0th Meridian is at 180 degrees, and they move in a clockwise direction 
		 */
		for(int i = 0; i < 24; i++) {
			this.meridians.add(new LineButton());
			this.getChildren().add(meridians.elementAt(i));
			this.meridians.elementAt(i).setTranslateY(85);
			meridians.elementAt(i).getTransforms().add(new Rotate(15*i, 1.5, 0));
			//this.meridians.elementAt(i).setTranslateX(125);
		}
	}
	
	private void defineMouseClicks() {

		/*
		 * Defines onMouseClicked Methods for all 24 meridians
		 * Changes the clicked meridian to blue
		 */
		this.meridians.elementAt(0).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 0;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});

		this.meridians.elementAt(1).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 1;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(2).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 2;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(3).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 3;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(4).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 4;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(5).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 5;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(6).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 6;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(7).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 7;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(8).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 8;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(9).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 9;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(10).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 10;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(11).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 11;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(12).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 12;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(13).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 13;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(14).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 14;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(15).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 15;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(16).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 16;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(17).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 17;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(18).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 18;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(19).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 19;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(20).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 20;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(21).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 21;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(22).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 22;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});
		
		this.meridians.elementAt(23).setOnMouseClicked( e-> {
			
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button");
			set = 23;
			this.meridians.elementAt(set).getStyleClass().remove(0);
			this.meridians.elementAt(set).getStyleClass().add("line-button-blue");
			
		});	
	}	

	private void createInnerTexts() {
		/*
		 * Function to add labels for all arcs
		 * Y axis offset for each is equal to radius of arc
		 * the extra 7.5 in label for 30 is due to the lack of visibility caused by dark arc
		 */
		Text text = new Text("30");
		text.getStyleClass().add("inner-text");
		this.getChildren().add(text);
		text.setTranslateY(-67.5);
		
		text = new Text("60");
		text.getStyleClass().add("inner-text");
		this.getChildren().add(text);
		text.setTranslateY(-105);
		
		text = new Text("90");
		text.getStyleClass().add("inner-text");
		this.getChildren().add(text);
		text.setTranslateY(-140);
		
		text = new Text("120");
		text.getStyleClass().add("inner-text");
		this.getChildren().add(text);
		text.setTranslateY(-160);
	}
}
