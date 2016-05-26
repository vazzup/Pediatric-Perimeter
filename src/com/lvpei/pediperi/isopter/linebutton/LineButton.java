package com.lvpei.pediperi.isopter.linebutton;

import javafx.scene.control.Control;

public class LineButton extends Control {

	public LineButton() {
		this.getStyleClass().add("line-button");
	}
	
	@Override
	public String getUserAgentStylesheet() {
		return LineButton.class.getResource("LineButton.css").toExternalForm();
	}
	
}
