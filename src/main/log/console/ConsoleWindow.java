package main.log.console;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.log.Log;
import main.log.console.gui.ConsoleArea;

public class ConsoleWindow extends JFrame {
	
	public ConsoleWindow() {
		super("Console");
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(500, 300));
		setResizable(false);
		{
			ConsoleArea ca = ConsoleStream.getConsoleArea();
			
			JScrollPane sp = new JScrollPane(ca);
			add(sp);
		}
		pack();
		setVisible(true);
		Log.info("Console GUI loaded sucessfully.");
	}
	
}
