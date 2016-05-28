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
	
	double radius = 200, canvasSide = 500, diameter = 2*radius;  //radius, diameter of rim and size of canvas
	Canvas canvas;	//canvas for circles
	final private int numberOfMeridians = 24;	//number of meridians(duh)
	Vector <LineButton> meridians;	//collections of all meridians
	private Text clickedText = null;	//currently clicked text
	private LineButton clickedLineButton = null;	//currently clicked line button
	
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
		this.drawCircles(radius);
		this.getChildren().add(canvas);
		
		//Create inner labels
		this.createInnerTexts(radius);
		
		//Create outer labels
		this.createOuterTexts();
		
		//Create meridian LineButtons and add to layout
		this.buildMeridians();
		
		//Add StyleSheet for Texts
		this.getStylesheets().add(Isopter.class.getResource("Isopter.css").toExternalForm());
		
	}
	
	private void drawCircles(double radius) {
		
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
		graphicsContext.setLineWidth(1);
		graphicsContext.setStroke(Color.BLACK);
		int angle = 90;
		double projectedRadialDistance = Math.sin(Math.toRadians(angle))*radius; 
		double positionInCanvas = this.canvasSide/2 - projectedRadialDistance;
		graphicsContext.strokeOval(positionInCanvas, positionInCanvas, 2*projectedRadialDistance, 2*projectedRadialDistance);	//180
		graphicsContext.setStroke(Color.rgb(0, 0, 0, 0.25));
		for(angle-=15;angle>15;angle-=15) {
			projectedRadialDistance = Math.sin(Math.toRadians(angle))*radius;
			positionInCanvas = this.canvasSide/2 - projectedRadialDistance;
			graphicsContext.strokeOval(positionInCanvas, positionInCanvas, 2*projectedRadialDistance, 2*projectedRadialDistance);
		}
		graphicsContext.setStroke(Color.BLACK);
		projectedRadialDistance = Math.sin(Math.toRadians(angle))*radius;
		positionInCanvas = this.canvasSide/2 - projectedRadialDistance;
		graphicsContext.strokeOval(positionInCanvas, positionInCanvas, 2*projectedRadialDistance, 2*projectedRadialDistance);	//30
		graphicsContext.setStroke(Color.RED);
	}
	
	private void buildMeridians() {
		/*
		 *Function to create and add meridians to isopter
		 *meridians are LineButtons
		 *0th Meridian is at 270 degrees, and they move in a clockwise direction 
		 */
		for(int i = 0; i < numberOfMeridians; i++) {
			LineButton lineButton = new LineButton();
			lineButton.setTranslateY(100);
			lineButton.getTransforms().add(new Rotate(15*i, 1, 0));
			lineButton.setOnMouseClicked( e-> {
				if(this.clickedLineButton != null) {
					this.clickedLineButton.getStyleClass().remove(0);
					this.clickedLineButton.getStyleClass().add("line-button");
				}
				this.clickedLineButton = lineButton;
				lineButton.getStyleClass().remove(0);
				lineButton.getStyleClass().add("line-button-blue");
			});
			this.getChildren().add(lineButton);
		}
	}
	
	public void dodo() {
		GraphicsContext graphicsContext = this.canvas.getGraphicsContext2D();
		graphicsContext.strokeLine(250, 0, 250, 500);
	}
	
	private void createInnerTexts(double radius) {
		/*
		 * Function to add labels for all arcs
		 * Y axis offset for each is equal to radius of arc
		 * the extra 7.5 in label for 30 is due to the lack of visibility caused by dark arc
		 */
		Text text = new Text("30");
		text.getStyleClass().add("inner-text");
		this.getChildren().add(text);
		text.setTranslateY(-1 * (Math.sin(Math.toRadians(15))*radius) - 7.5);
		
		text = new Text("60");
		text.getStyleClass().add("inner-text");
		this.getChildren().add(text);
		text.setTranslateY(-1 * (Math.sin(Math.toRadians(30))*radius));
		
		text = new Text("90");
		text.getStyleClass().add("inner-text");
		this.getChildren().add(text);
		text.setTranslateY(-1 * (Math.sin(Math.toRadians(45))*radius));
		
		text = new Text("120");
		text.getStyleClass().add("inner-text");
		this.getChildren().add(text);
		text.setTranslateY(-1 * (Math.sin(Math.toRadians(60))*radius));
		
		text = new Text("150");
		text.getStyleClass().add("inner-text");
		this.getChildren().add(text);
		text.setTranslateY(-1 * (Math.sin(Math.toRadians(75))*radius));
	}

	private double calculateXOffset (double angleFromTwoSeventy, double polarDistance) {
		return Math.sin(Math.toRadians(angleFromTwoSeventy))*(polarDistance+10.5);
	}
	
	private double calculateYOffset (double angleFromTwoSeventy, double polarDistance) {
		return Math.cos(Math.toRadians(angleFromTwoSeventy))*(polarDistance+10.5);
	}

	private void createOuterTexts() {
		
		int angle;
		for(angle = 0; angle<360; angle+=15) {
			Text text = new Text(String.valueOf(angle));
			text.getStyleClass().add("outer-text");
			text.setTranslateX(calculateXOffset(angle - 270.0, radius));
			text.setTranslateY(calculateYOffset(angle - 270.0, radius));
			text.setOnMouseClicked( e -> {
				if(this.clickedText != null) {
					clickedText.getStyleClass().remove(0);
					clickedText.getStyleClass().add("outer-text");
				}
				clickedText = text;
				System.out.println(text.getText() + " clicked");
				text.getStyleClass().remove(0);
				text.getStyleClass().add("outer-text-selected");
			});
			this.getChildren().add(text);
		}
		
	}

	public void addReading(double angle, double readingAngle) {
		GraphicsContext graphicsContext = this.canvas.getGraphicsContext2D();
		double projectedRadialDistance = Math.sin(Math.toRadians(readingAngle))*this.radius;
		double xOffset = Math.sin(Math.toRadians(angle- 270.0))*projectedRadialDistance;
		double yOffset = Math.cos(Math.toRadians(angle- 270.0))*projectedRadialDistance;
		System.out.println(projectedRadialDistance + " " + xOffset + " " + yOffset);
		graphicsContext.strokeOval(this.canvasSide/2 + xOffset - 5,this.canvasSide/2 +  yOffset - 5, 10, 10);
	}
}