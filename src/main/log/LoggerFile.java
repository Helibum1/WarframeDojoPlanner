package main.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import main.log.console.gui.ConsoleArea;

public class LoggerFile {
	
	public static void saveLog(ConsoleArea ca, String fileName) throws IOException {
		
		BufferedWriter outfile = new BufferedWriter(new FileWriter(checkName(fileName) + ".txt"));
	   	try {
			outfile.write(ca.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    outfile.close();
		
	}
	
	public static String checkName(String fileName) {
		String tempFileName = fileName;
		int times = 1;
		File folder = new File("logs/");
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        Log.debug("File " + listOfFiles[i].getName());
		        if (listOfFiles[i].getName() == tempFileName) {
		        	break;
		        } else {
		        	tempFileName = fileName;
		        	tempFileName = tempFileName + Integer.toString(times);
		        	++times;
		        }
		      } /**else if (listOfFiles[i].isDirectory()) {
		        Log.debug("Directory " + listOfFiles[i].getName());
		      }*/
		    }
			return tempFileName;
	}

}
