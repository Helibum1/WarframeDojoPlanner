package main.objects.components;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;

import main.log.Log;

public class Room {
	
	public enum Material {
		credits, alloyPlate, circuits, controlModules, ferrite, gallium, morphics, neuralSensors, 
		neurodes, orokinCells, rubedo, salvage, plastids, polymerBundle, argonCrystal, cryotic, 
		oxium, tellurium, detoniteAmpule, fieldronSample, mutagenSample, fieldron, mutagenMass, 
		space, energy
	}
	
	String name;
	HashMap<String, HashMap<Material, Integer>> costs = new HashMap<String, HashMap<Material, Integer>>();
	int decoCap;
	
	int counter = 0;
	List<Point> doors;
	
	
	public Room(String identifyer) {
		Log.debug("Setting up HashMap for " + identifyer);
		costs.put("ghost", new HashMap<Material, Integer>());
		costs.put("shadow", new HashMap<Material, Integer>());
		costs.put("storm", new HashMap<Material, Integer>());
		costs.put("mountain", new HashMap<Material, Integer>());
		costs.put("moon", new HashMap<Material, Integer>());
		setProperties(Loader.getProperties(identifyer + ".rdef"));
		Log.debug("Hashmaps set for " + identifyer);
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
			doors.add(new Point(Integer.parseInt(arst.split(",")[0]), Integer.parseInt(arst.split(",")[1])));
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
	
	public Point getNextDoor() {
		counter++;
		if (counter >= doors.size() || counter < 0) {
			counter = 0;
		}
		return doors.get(counter);
	}
	
	public Point getDefaultDoor() {
		counter = 0;
		return doors.get(counter);
	}
	
}