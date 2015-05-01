package main.objects.components;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.log.Log;
import main.objects.Grid;

public class Room {
	
	public final String identifyer;
	
	long id;
	
	Grid grid;
	
	Room attachedTo = null;
	
	String name;
	HashMap<String, HashMap<Material, Integer>> costs = new HashMap<String, HashMap<Material, Integer>>();
	int decoCap;
	
	int counter = 0;
	List<Door> doors;
	
	Image img;
	
	Dependency dependencies;
	
	int x = 0, y = 0;
	
	
	public Room(String identifyer, Grid grid, Room attachedTo) {
		this.identifyer = identifyer;
		this.grid = grid;
		this.doors = new ArrayList<Door>();
		id = grid.getRooms().size();
		Log.debug("Setting up HashMap for '" + identifyer + "' with roomid " + id);
		costs.put("ghost", new HashMap<Material, Integer>());
		costs.put("shadow", new HashMap<Material, Integer>());
		costs.put("storm", new HashMap<Material, Integer>());
		costs.put("mountain", new HashMap<Material, Integer>());
		costs.put("moon", new HashMap<Material, Integer>());
		setProperties(Loader.getProperties(identifyer + ".rdef"));
		Log.debug("Hashmaps set for " + identifyer);
		this.attachedTo = attachedTo;
		Log.info("Attached '" + this.getName() + "' to '" + attachedTo.getName() + "'");
	}

	void setProperties(String[] properties) {
		Log.debug("Setting properties");
		for (int i = 0; i < properties.length; i++) {
			switch (properties[i].split(":")[0]) {
			case "name": name = properties[i].split(":")[1];break;
			case "doors": setDoors(properties[i].split(":")[1]);break;
			case "costs": setCosts(properties[i].split(":")[1]);break;
			case "deco-cap": decoCap = Integer.parseInt(properties[i].split(":")[1]);break;
			case "storm": override("storm", properties[i].split(":")[1]);break;
			case "shadow": override("shadow", properties[i].split(":")[1]);break;
			case "mountain": override("mountain", properties[i].split(":")[1]);break;
			case "moon": override("moon", properties[i].split(":")[1]);break;
			case "dependencies": dependencies = new Dependency("energy:" + costs.get(Material.energy)
					, "space:" + costs.get(Material.space), properties[1].split(":")[1].split(";"));
			}
		}
		Log.debug("Properties set");
	}
	
	void override(String level, String str) {
		costs.get("level").put(Material.valueOf(str.split(" ")[0]), Integer.parseInt(str.split(" ")[1]));
	}
	
	void setDoors(String str) {
		Log.debug("Setting door-coords");
		String[] arr = str.split(";");
		doors.clear();
		for (String arst : arr) {
			doors.add(new Door(Integer.parseInt(arst.split(",")[0]), Integer.parseInt(arst.split(",")[1])));
		}
		Log.debug("Door-coords set");
	}
	
	void setCosts(String str) {
		Log.debug("Setting costs");
		String[] arr = str.split(",");
		costs.get("ghost").clear();
		costs.get("shadow").clear();
		costs.get("storm").clear();
		costs.get("mountain").clear();
		costs.get("moon").clear();
		for (String tmp : arr) {
			costs.get("ghost").put(Material.valueOf(tmp.split(" ")[0]), Integer.parseInt(tmp.split(" ")[1]));
		}
		for (String tmp : arr) {
			costs.get("shadow").put(Material.valueOf(tmp.split(" ")[0]), Integer.parseInt(tmp.split(" ")[1])*3);
		}
		for (String tmp : arr) {
			costs.get("storm").put(Material.valueOf(tmp.split(" ")[0]), Integer.parseInt(tmp.split(" ")[1])*10);
		}
		for (String tmp : arr) {
			costs.get("mountain").put(Material.valueOf(tmp.split(" ")[0]), Integer.parseInt(tmp.split(" ")[1])*30);
		}
		for (String tmp : arr) {
			costs.get("moon").put(Material.valueOf(tmp.split(" ")[0]), Integer.parseInt(tmp.split(" ")[1])*100);
		}
		Log.debug("Costs set");
	}
	
	public String getName() {
		return name;
	}
	
	public int getDecoCap() {
		return decoCap;
	}
	
	public Door getNextDoor() {
		counter++;
		if (counter >= doors.size() || counter < 0) {
			counter = 0;
		}
		return doors.get(counter);
	}
	
	public Door getDoor(int index) {
		return doors.get(index);
	}
	
	public Dependency getDependencies() {
		return dependencies;
	}
	
	public Door getDefaultDoor() {
		counter = 0;
		return doors.get(counter);
	}

	public Image getImage() {
		return null;
	}
	
	public Point getPos() {
		return new Point(x, y);
	}
	
	public boolean checkDestruction() {
		for (Door d : doors) {
			if (d.isOccupied()) {
				return false;
			}
		}
		return true;
	}
	
}