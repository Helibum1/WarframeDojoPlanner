package main.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import main.objects.components.Door;
import main.objects.components.GridDependency;
import main.objects.components.Room;

@SuppressWarnings("serial")
public class Grid extends JPanel {
	
	private BufferedImage background = new BufferedImage(10000, 10000, 0);
	
	private List<Room> rooms = new ArrayList<Room>();
	
	private GridDependency dependencies = new GridDependency();
	
	public Grid() {
		
	}
	
	public void addRoom(Room r, Room attachedTo, int doorIndex) {
		rooms.add(r);
		dependencies.add(r.getDependencies());
		attachedTo.getDoor(doorIndex).attach(r);
	}
	
	public List<Room> getRooms() {
		return rooms;
	}
	
	public void redraw() {
		for (Room r : rooms) {
			background.getGraphics().drawImage(r.getImage(), r.getPos().x, r.getPos().y, this);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
	}
	
	private void addDoors() {
		
	}
	
}
