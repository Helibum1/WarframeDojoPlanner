package main.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.log.console.gui.ConsoleArea;

public class LoggerFile {
	
	public LoggerFile() {
		
	}
	
	private String dir = null;
	
	private static BufferedWriter w;
	
	public LoggerFile(String dir) {
		this.dir = dir;
		try {
			checkDirName(this.dir);
		} catch (IOException e) {
			e.printStackTrace(Log.cs);
		}
	}
	
	public static void saveLog(ConsoleArea ca,String folderName, String fileName) throws IOException {
		
		File logFolder = new File(folderName);
		if (!logFolder.isDirectory()) {
			logFolder.mkdir();
		}
		
		switch (folderName) {
		
		case "logs": {
			BufferedWriter outfile = new BufferedWriter(new FileWriter(folderName + "/" + checkNameLog()));
		   	try {
				outfile.write(ca.getText());
			} catch (IOException e) {
				e.printStackTrace(Log.cs);
			}
		    outfile.close();
		}
		
		}
		
		
	}
	
	public BufferedWriter getFullWriter() {
		return w;
	}
	
	public static String checkNameLog() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy_MM_dd-HH-mm-ss");
		String fname  = "log-" + format.format(date);
		if (!(new File(fname + ".log")).exists()) {
			return fname + ".log";
		} else {
			return fname + "(2).log";
		}
	
	}
	
	public static void closeSteam() {
		try {
			w.close();
		} catch (IOException e) {
			e.printStackTrace(Log.cs);
		}
	}
	
	public static void checkDirName(String dir) throws IOException {
		if (!(new File("logs\\" + dir).isDirectory())) {
			(new File("logs\\" + dir)).mkdirs();
		}
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy_MM_dd-HH-mm-ss");
		String fname  = "full-log-" + format.format(date);
		if (!(new File("logs\\" + dir + "\\" + fname + ".log")).exists()) {
			w = new BufferedWriter(new FileWriter("logs\\" + dir + "\\" + fname + ".log"));
		} else {
			w = new BufferedWriter(new FileWriter("logs\\" + dir + "\\" + fname + "(2).log"));
		}
	}

}
