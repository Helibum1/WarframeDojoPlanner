package main.log.console;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import main.log.console.gui.ConsoleArea;


public class ConsoleStream extends BufferedOutputStream {
	
	private ConsoleArea area = new ConsoleArea();
	
	private static OutputStream str = new OutputStream() {

		@Override
		public void write(int b) throws IOException {
			
		}};

	public ConsoleStream() {
		super(str);
	}


}
