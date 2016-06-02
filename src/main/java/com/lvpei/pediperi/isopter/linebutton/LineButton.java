package com.lvpei.pediperi.isopter.linebutton;

import javafx.scene.control.Control;

public class LineButton extends Control {

	/**
	 * @author Vatsal Kanakiya
	 * @since 2016 - 05- 25
	 * @version 1.0
	 * DO NOT TOUCH
	 */
	
	public LineButton() {
		this.getStyleClass().add("line-button");
	}
	
	@Override
	public String getUserAgentStylesheet() {
		return LineButton.class.getResource("LineButton.css").toExternalForm();
	}
	
}
