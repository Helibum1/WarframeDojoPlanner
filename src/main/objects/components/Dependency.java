package main.objects.components;

public class Dependency {
	
	String[] dep;
	
	public Dependency(String string, String string2, String ... deps) {
		dep = deps;
	}

	public String[] getObjects() {
		return dep;
	}
	
	public int getQuantityOf(String name) {
		for (String s : dep) {
			if (name.equals(s.split("=")[0])) {
				return Integer.parseInt(s.split("=")[1]);
			}
		}
		return 0;
	}

}
