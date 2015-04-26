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
	
	public static void saveLog(ConsoleArea ca, String fileName) throws IOException {
		
		File logFolder = new File("logs");
		if (!logFolder.isDirectory()) {
			logFolder.mkdir();
		}
		
		BufferedWriter outfile = new BufferedWriter(new FileWriter("logs/" + checkName(fileName)));
	   	try {
			outfile.write(ca.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    outfile.close();
		
	}
	
	public static String checkName(String fileName) {
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
