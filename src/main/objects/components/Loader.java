package main.objects.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import main.log.Log;

public class Loader {
	/**
	 * Loads the properties of a room from the file associated with it
	 * @param identifyer The identifyer of the room to be loaded. Is the same as the name of the file of this room
	 * @return A string-array with the properties of the room which was loaded
	 */
	public static String[] getProperties(String identifyer) {
		Log.debug("Starting to read config for " + identifyer);
		String tmp = "";
		try {
			BufferedReader r = new BufferedReader(new FileReader(new File("rooms/" + identifyer)));
			while (r.readLine() != null) {
				tmp += r.readLine();
			}
			r.close();
		} catch (IOException e) {
			e.printStackTrace(Log.cs);
		}
		return tmp.split("\n");
	}
}
