package main;

import java.util.HashMap;

import main.log.Log;
import main.security.NameCollisionException;

public class Planner implements Runnable {
	
	private static final int ACTIONS_PER_SECOND = 30;
	
	/** The handler that should receive the user input. */
	private final InputHandler inputHandler = new InputHandler();
	
	private static Config cfg;

	public Planner() {
		cfg = new Config();
		try {
			cfg.registerConfiguration("main", new HashMap<String, Object>());
		} catch (NameCollisionException e) {
			e.printStackTrace();
		}
		Log.setDefaultLevel();
	}
	
	@Override
	public void run() {
		
		while (true) {
			// This loop goes forever, since we don't want our application
			// logic to stop.
			
			
			// Update the input state.
			inputHandler.updatedReleasedKeys();
			
			// Delay the next action (iteration of the loop).
			try {
				Thread.sleep((long) (1000.0f/ACTIONS_PER_SECOND));
				
			} catch (InterruptedException e) {
				// We were interrupted, exit the application loop.
				
				Log.error("Caught interruption exception, exiting application loop.");
				e.printStackTrace(Log.cs);
				break;
			}
			
		}
		
	}

	public InputHandler getInputHandler() {
		return inputHandler;
	}
	
	public static Config getConfig() {
		return cfg;
	}
	
}
