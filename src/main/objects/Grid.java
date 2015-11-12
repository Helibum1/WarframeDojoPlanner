package main.objects;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import main.objects.components.Door;
import main.objects.components.GridDependency;
import main.objects.components.Room;

@SuppressWarnings("serial")
public class Grid extends JPanel {
	
	private List<Room> rooms = new ArrayList<Room>();
	
	private GridDependency dependencies = new GridDependency();
	
	public Grid() {
		addRoom();
	}
	
	/**
	 * Adds a new room to this grid
	 * @param r The room to be added
	 * @param attachedTo The room the room r is connected to
	 * @param doorIndex The door-index of the door of the existing room to which the room r is attached to
	 */
	public void addRoom(Room r, Room attachedTo, int doorIndex) {
		rooms.add(r);
		dependencies.add(r.getDependencies());
		try {
			attachedTo.getDoor(doorIndex).attach(r);
		} catch(NullPointerException e) {
			if (!(r.getName()=="Hall")) {
				e.printStackStrace();
			}
		}
	}
	
	/**
	 * Getter for a list containing all rooms on this grid
	 * @return A list containing all rooms on this grid
	 */
	public List<Room> getRooms() {
		return rooms;
	}
	
	/**
	 * Redraws every room on the grid
	 */
	public void redraw() {
		for (Room r : rooms) {
			
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
	}
	
	private void addDoors() {
		
	}
	
}
