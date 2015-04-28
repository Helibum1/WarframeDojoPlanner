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
	
	public void attach(Room r) {
		owith = r;
		b.setEnabled(false);
	}
	
	public void destroyAttached() {
		owith = null;
		b.setEnabled(true);
	}
	
}
