package main.objects;

import java.awt.Graphics;

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
	
	/** Updates the object to be rendered, forcing it into it's latest state.
	 */
	public abstract void update(Runnable r);
	
	/** Renders an image, which will be drawn onto the grid.
	 */
	public abstract void renderInternal(Graphics g);

}
