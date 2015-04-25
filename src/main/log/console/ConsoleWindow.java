package main.log.console;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.log.console.gui.ConsoleArea;

public class ConsoleWindow extends JPanel {
	
	public ConsoleWindow() {
		ConsoleArea ca = ConsoleStream.getConsoleArea();
		JScrollPane scrollPane = new JScrollPane(ca);
		add(scrollPane);
	}
	
	public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TextDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(new ConsoleWindow());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
