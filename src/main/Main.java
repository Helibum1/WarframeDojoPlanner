package main;

import java.awt.EventQueue;

import main.log.console.ConsoleWindow;
import main.objects.components.Room;

public class Main {

	public static void main(String[] args) {

		/*
		 * Run the command to create the window (the JFrame) in the separate
		 * drawing thread. In swing, all commands that draw something should be
		 * run within this drawing thread, even though this is not enforced.
		 * Commands can be put to be executed in this thread by calling
		 * "EventQueue.invokeLater(...)" .
		 */
		EventQueue.invokeLater(new Runnable() {

			// This function specifies the commands which the drawing thread
			// should execute.
			@Override
			public void run() {
				
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                new ConsoleWindow();
		            }
		        });
				
				
				// Create the Game object.
				Planner planner = new Planner();

				// Create the window (the JFrame).
				Window window = new Window(planner);
				window.setVisible(true);
				
				// Start the game!
				new Thread(planner).start();
			}
  });
    }

}