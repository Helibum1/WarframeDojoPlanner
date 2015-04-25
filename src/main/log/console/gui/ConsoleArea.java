package main.log.console.gui;

import java.awt.Color;

import javax.swing.JTextArea;

public class ConsoleArea extends JTextArea {
	private static final long serialVersionUID = 5063354137396740677L;
	
	public ConsoleArea() {
		super.setEditable(false);
		super.setBackground(Color.DARK_GRAY);
	}
	
	@Override
	public void setEditable(boolean b) {
		
	}
	
}
