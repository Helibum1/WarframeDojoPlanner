package main.objects.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import main.log.Log;

public class Loader {
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
			e.printStackTrace();
		}
		return tmp.split("\n");
	}
}
