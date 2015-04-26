package main;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import main.log.Log;

/**
 * Class that handles the input of the user. It stores the keys that are
 * currently pressed.
 */
public class ScrollWheelHandler {
	
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
	public void handleMouseWheelEvent(MousWheelEvent wheelEvent) {

		// The code of the key that is associated with this event.
		int scroll =  keyEvent.getUnitsToScroll();
		
	}

}
