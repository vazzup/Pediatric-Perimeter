package com.lvpei.pediperi.isopter;

import java.util.Vector;

import com.lvpei.pediperi.isopter.linebutton.LineButton;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Isopter extends StackPane{
	
	int diameter = 250, canvasSide = 300;
	Canvas canvas;
	Vector <LineButton> meridians;
	public Isopter() {
		
		//All Buttons
		meridians = new Vector<LineButton>();
		
		
		//Canvas for Circles
		canvas = new Canvas(canvasSide, canvasSide);
		
		//draw the circles
		drawCircles(diameter);
	}
	
	private void drawCircles(int diameter) {
		
		GraphicsContext graphicsContext = this.canvas.getGraphicsContext2D();
		graphicsContext.setFill(Color.BLACK);
		graphicsContext.strokeOval(250, 250, 200, 200);
		graphicsContext.strokeOval(250, 250, 175, 175);
		graphicsContext.strokeOval(250, 250, 145, 145);
		graphicsContext.strokeOval(250, 250, 105, 105);
		graphicsContext.strokeOval(250, 250, 60, 60);
	}
	
}
