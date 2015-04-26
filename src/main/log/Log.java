package main.log;

import java.awt.Color;
import java.util.Date;

import main.log.console.ConsoleStream;

public class Log {
	
	public enum Level {
		DEBUG, INFO, WARNING, ERROR
	}

	private static Level CURRENT_LEVEL = Level.INFO;
	
	private static Date date = new Date();
	
	private static DateFormat format = new DateFormat("yyyy/MM/dd HH:mm:ss");
	
	public static final ConsoleStream cs = new ConsoleStream();
	
	/**
	 * Set the level of this logger.
	 *
	 * @param level
	 *            The new level of the logged objects.
	 */
	public static void setLevel(Level level) {
		
		CURRENT_LEVEL = level;
	}
	
	/**
	 * Log a message if the currently set level is lower or equal to the
	 * provided level.
	 *
	 * @param level
	 *            The level of this message.
	 * @param message
	 *            The message to log.
	 */
	public static void log(Level level, String message) {
		
		if (CURRENT_LEVEL.ordinal() <= level.ordinal()) {
			cs.println(message);
			/**switch (level) {
			
			case ERROR:ConsoleStream.output(message,Color.RED); break;
			
			case WARNING:ConsoleStream.output(message,Color.YELLOW); break;
			
			case INFO:ConsoleStream.output(message,Color.WHITE); break;
			
			default:ConsoleStream.output(message,Color.WHITE); break;
			}*/
		}
	}
	
	/**
	 * Convenience function to log error messages. This message is logged if the
	 * logger is set to error or lower.
	 *
	 * @param message	The message to log.
	 */
	public static void error(String message) {
		log(Level.ERROR, System.message);
	}
	
	/**
	 * Convenience function to log error messages. This message is logged if the
	 * logger is set to error or lower.
	 *
	 * @param message	The message to log.
	 */
	public static void warning(String message) {
		log(Level.WARNING, message);
	}
	
	/**
	 * Convenience function to log error messages. This message is logged if the
	 * logger is set to error or lower.
	 *
	 * @param message	The message to log.
	 */
	public static void info(String message) {
		log(Level.INFO, message);
	}
	
	/**
	 * Convenience function to log error messages. This message is logged if the
	 * logger is set to error or lower.
	 *
	 * @param message	The message to log.
	 */
	public static void debug(String message) {
		log(Level.DEBUG, message);
	}
	
}
