package main.objects;

import main.Canvas;

/**
 * This class can be extended by classes that can render themselves on the
 * {@link Canvas}.
 */
public abstract class RenderObject implements Comparable<RenderObject> {
	
	/** The X-Coordinate of the render Object */
	protected int x;
	
	/** The Y-Coordinate of the render Object */
	protected int y;
	
	/** The zIndex is responsible for how much in front an
	 * object will be drawn. The higher the Index is, the more on top
	 * the object will be drawn
	 */
	protected int zIndex;

}
