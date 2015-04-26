package main.objects.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Room {
	
	public Room(String identifyer) {
		setProperties(Loader.getProperties(identifyer));
	}

	private void setProperties(String[] properties) {
	}
	
}

class Loader {
	public static String[] getProperties(String identifyer) {
		String tmp = "";
		try {
			BufferedReader r = new BufferedReader(new FileReader(new File(identifyer)));
			while (r.readLine() != null) {
				tmp += r.readLine();
			}
			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tmp.split("\n");
	}
}