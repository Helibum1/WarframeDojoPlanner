package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import main.log.Log;

import com.jcabi.github.*;


public class Update {
	
	static Github github = new RtGithub();
	static Repos repos = github.repos();
	static Repo repo = repos.get(new Coordinates.Simple("Helibum1/WarframeDojoPlanner"));
	static Contents contents = repo.contents();
	static Content content = getContent();
	static InputStream inputStream;
	static FileOutputStream outputStream;
	
	private static Content getContent() {
		Content result = null;
		try {
			result = contents.get("rooms");
		} catch (IOException e) {
			e.printStackTrace(Log.cs);
		}
		return result;
	}
	
	public static void Updater() {
		System.out.println(inputStream.toString());
	}
}
