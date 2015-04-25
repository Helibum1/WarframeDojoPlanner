package main.log.console;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import main.log.console.gui.ConsoleArea;

public class ConsoleStream extends PrintStream {
	
	private static ConsoleArea ca = new ConsoleArea();
	
	private static OutputStream os = new OutputStream() {

		@Override
		public void write(int b) throws IOException {
			ca.append(String.valueOf((char) b));
		}
		
	};

	public ConsoleStream() {
		super(os);
	}
	
	public static ConsoleArea getConsoleArea() {
		return ca;
	}
	
}
