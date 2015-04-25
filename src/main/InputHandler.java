package main;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import main.log.Log;

/**
 * Class that handles the input of the user. It stores the keys that are
 * currently pressed.
 */
public class InputHandler {
	
	/** A set containing all keys that are pressed. */
	private final Set<Integer> keyPressed = new HashSet<Integer>();
	
	/** A set that contains the keys that are released and that
	 * should be removed from the keyPressed set in the near future.
	 */
	private final Set<Integer> keyReleased = new HashSet<Integer>();
	
	/**
	 * Handle what should be done upon a certain key event.
	 * 
	 * @param keyEvent
	 *            The keyEvent that was triggered by the user.
	 */
	public void handleKeyEvent(KeyEvent keyEvent) {

		// The code of the key that is associated with this event.
		int key =  keyEvent.getKeyCode();
		
		switch(keyEvent.getID()) {
		
		case KeyEvent.KEY_PRESSED: 
			Log.debug("Pressed key: " + key);
			keyPressed.add(key);
			break;
			
		case KeyEvent.KEY_RELEASED: 
			Log.debug("Released key: " + key);
			keyReleased.add(key);
			break;
		
		default: 
			break;
		}
		
	}
	
	/**
	 * Check if a certain key is pressed.
	 * 
	 * @param keyCode
	 *            The keyCode to check.
	 * @return True, if the key is pressed.
	 */
	public boolean isKeyPressed(int keyCode) {
		
		return keyPressed.contains(keyCode);
	}
	
	/**
	 * Helper function to remove all keys from the keyPressed set
	 * that have been released since the last iteration of the game
	 * loop.<br>
	 * <br>
	 * This enables us to see very short keypresses also, namely the
	 * ones that were pressed and released within one iteration of the
	 * game loop.
	 */
	public void updatedReleasedKeys() {
		
		// Remove all keys that have been released since we last checked.
		for (int keyCode : keyReleased) {
			keyPressed.remove(keyCode);
		}
		
		// Clear the keys that are released, since
		// they are handled now.
		keyReleased.clear();
		
	}

}