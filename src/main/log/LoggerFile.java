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
	
	public static void saveLog(ConsoleArea ca,String folderName, String fileName) throws IOException {
		
		File logFolder = new File(folderName);
		if (!logFolder.isDirectory()) {
			logFolder.mkdir();
		}
		
		switch (folderName) {
		
		case "logs": {
			BufferedWriter outfile = new BufferedWriter(new FileWriter(folderName + "/" + checkNameLog(fileName)));
		   	try {
				outfile.write(ca.getText());
			} catch (IOException e) {
				e.printStackTrace();
			}
		    outfile.close();
		}
		
		//case
		
		}
		
		
	}
	
	public static String checkNameLog(String fileName) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy_MM_dd-HH-mm-ss");
		String fname  = "log-" + format.format(date);
		System.gc();
		if (!(new File(fname + ".log")).exists()) {
			return fname + ".log";
		} else {
			return fname + "(2).log";
		}
	}

}
