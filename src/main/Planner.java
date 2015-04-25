package main;

import java.util.HashSet;
import java.util.Set;

import main.log.Log;
import main.objects.RenderObject;
import main.InputHandler;

public class Planner implements Runnable {
	
	private static final int ACTIONS_PER_SECOND = 30;
	
	/** A list of all objects that can be rendered. */
	private final static Set<RenderObject> objectsToRender = new HashSet<RenderObject>();
	
	private final Set<RenderObject> objectsToAdd = new HashSet<RenderObject>();

	public Set<RenderObject> getObjectsToAdd() {
		return objectsToAdd;
	}

	public static Set<RenderObject> getObjectsToRemove() {
		return objectsToRemove;
	}

	private final static Set<RenderObject> objectsToRemove = new HashSet<RenderObject>();
	
	/** The handler that should receive the user input. */
	private final InputHandler inputHandler = new InputHandler();

	public Planner() {
		
		new Grid(this);
		
	}
	
	@Override
	public void run() {
		
		while (true) {
			// This loop goes forever, since we don't want our game
			// logic to stop.
						
			// Update all game objects.
			for (RenderObject object : objectsToRender) {
				object.update(this);
			}
			
			objectsToRender.removeAll(objectsToRemove);
			objectsToRender.addAll(objectsToAdd);
			
			objectsToAdd.clear();
			objectsToRemove.clear();
			
			// Update the input state.
			inputHandler.updatedReleasedKeys();
			
			Log.warning("asdfasdf");
			
			// Delay the next action (iteration of the loop).
			try {
				Thread.sleep((long) (1000.0f/ACTIONS_PER_SECOND));
				
			} catch (InterruptedException e) {
				// We were interrupted, exit the game loop.
				
				Log.error("Caught interruption exception, exiting game loop.");
				e.printStackTrace();
				break;
			}
			
		}
		
	}
	
	public Set<RenderObject> getObjectsToRender() {
		return objectsToRender;
	}

	public InputHandler getInputHandler() {
		return inputHandler;
	}
	
}
