package main.objects.components;

import java.util.HashMap;

public class GridDependency {
	
	private HashMap<String, Integer> dep;
	
	public GridDependency() {
		dep = new HashMap<String, Integer>();
	}
	
	public void add(Dependency d) {
		for (String str : d.getObjects()) {
			if (dep.containsKey(str.split(":")[0])) {
				
			} else {
				dep.put(str.split(":")[0], Integer.parseInt(str.split(":")[1]));
			}
		}
	}
	
	public void remove(Dependency d) {
		
	}
	
}
