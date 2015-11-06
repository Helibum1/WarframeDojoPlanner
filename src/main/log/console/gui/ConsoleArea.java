package main.log.console.gui;

import java.io.IOException;

import javax.swing.JTextArea;

import main.log.LoggerFile;

public class ConsoleArea extends JTextArea {
	private static final long serialVersionUID = 5063354137396740677L;
	private static ConsoleArea ca;
	
	public ConsoleArea() {
		super.setEditable(false);
		ConsoleArea ca = this;
		ConsoleArea.ca = ca;
	}
	
	@Override
	public void setEditable(boolean b) {
		
	}
	
	/**
	 * Saves the content of the console to a log
	 * @throws IOException
	 */
	public static void save() throws IOException {
		LoggerFile.saveLog(ca, "logs", "log");
	}
	
}
