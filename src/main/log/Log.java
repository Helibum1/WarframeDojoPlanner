package main.log;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.Planner;
import main.log.console.ConsoleStream;
import main.security.NoSuchConfigException;
import main.security.NoSuchKeyException;

public class Log {
	
	public enum Level {
		FINEST, DEBUG, INFO, WARNING, ERROR
	}

	private static Level CURRENT_LEVEL = Level.DEBUG;
	
	private static Date date = new Date();
	
	private static DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public static final ConsoleStream cs = new ConsoleStream();
	
	private static LoggerFile fullLog = new LoggerFile("full-logs");
	
	/**
	 * Set the level of this logger.
	 *
	 * @param level
	 *            The new level of the logged objects.
	 */
	public static void setLevel(Level level) {
		
		CURRENT_LEVEL = level;
	}
	
	public static void setDefaultLevel() {
		Planner.getConfig().setDefault("main", "LoggerLevel", Level.DEBUG);
		try {
			CURRENT_LEVEL = (Level) Planner.getConfig().getEntry("main", "LoggerLevel");
		} catch (NoSuchConfigException e) {
			e.printStackTrace(cs);
		} catch (NoSuchKeyException e) {
			e.printStackTrace(cs);
		}
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
		
		try {
			fullLog.getFullWriter().append(message + "\n");
		} catch (IOException e) {
			e.printStackTrace(cs);
		}
		
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
		log(Level.ERROR, "[ERROR][" + format.format(date).split(" ")[1] + "]" + message);
	}
	
	/**
	 * Convenience function to log error messages. This message is logged if the
	 * logger is set to error or lower.
	 *
	 * @param message	The message to log.
	 */
	public static void warning(String message) {
		log(Level.WARNING, "[WARNING][" + format.format(date).split(" ")[1] + "]" + message);
	}
	
	/**
	 * Convenience function to log error messages. This message is logged if the
	 * logger is set to error or lower.
	 *
	 * @param message	The message to log.
	 */
	public static void info(String message) {
		log(Level.INFO, "[INFO][" + format.format(date).split(" ")[1] + "]" + message);
	}
	
	/**
	 * Convenience function to log error messages. This message is logged if the
	 * logger is set to error or lower.
	 *
	 * @param message	The message to log.
	 */
	public static void debug(String message) {
		log(Level.DEBUG, "[DEBUG][" + format.format(date).split(" ")[1] + "]" + message);
	}
	
	/**
	 * Convenience function to log error messages. This message is logged if the
	 * logger is set to error or lower.
	 *
	 * @param message	The message to log.
	 */
	public static void finest(String message) {
		log(Level.FINEST, "[FINEST][" + format.format(date).split(" ")[1] + "]" + message);
	}
	
}
