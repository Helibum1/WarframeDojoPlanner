package main;

import java.awt.BorderLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.UIManager;

import main.log.Log;

@SuppressWarnings("serial")
public class Window extends JFrame {

	public static final String TITLE = "Warframe Dojo Builder";


	public Window(Planner planner) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace(Log.cs);
		}

		// Set the title of the JFrame (swing function).
		setTitle(TITLE);

		// Specify what should happen when the close button is clicked (Swing
		// function). 
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Specify the layout that should be used inside this JFrame (swing
		// function).
		setLayout(new BorderLayout());

		// Create the canvas on which we are going to draw the game.
		Canvas canvas = new Canvas(planner);
		canvas.setVisible(true);

		// Add the canvas to this JFrame (swing function).
		add(canvas, BorderLayout.CENTER);

		// This swing function is necessary so that the JFrame is rendered.
		pack();
		
		// Setup the the user input.
		setupInput(planner);

		Log.info("Initialized main window.");
	}

	/**
	 * This functions is used to setup all the handling of user inputs, e.g.,
	 * keystrokes.
	 * @param game 
	 */
	private void setupInput(final Planner planner) {

		KeyboardFocusManager.getCurrentKeyboardFocusManager()
				.addKeyEventDispatcher(new KeyEventDispatcher() {
			
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				planner.getInputHandler().handleKeyEvent(e);
				return false;
			}
		});

	}
	
}