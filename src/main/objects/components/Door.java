package main.objects.components;

import java.awt.Point;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Door extends Point {
	
	private Room owith = null;
	
	private JButton b = new JButton();
	
	public Door(int x, int y) {
		super(x, y);
	}

	public boolean isOccupied() {
		return owith != null;
	}
	
	/**
	 * Connects this door to another room
	 * @param r The room this door gets attached to
	 */
	public void attach(Room r) {
		owith = r;
		b.setEnabled(false);
	}
	
	/**
	 * The attached room got destroyed -> delete the room from this door and enable the button to create a new room at this location
	 */
	public void destroyAttached() {
		owith = null;
		b.setEnabled(true);
	}
	
}
