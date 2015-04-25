package main.objects;

import java.awt.Color;
import java.awt.Graphics;

import main.Canvas;

/**
 * This class can be extended by classes that can render themselves on the
 * {@link Canvas}.
 */
public abstract class RenderObject implements Comparable<RenderObject> {
	
	/** Should the bounding boxes of objects be drawn? */
	public static boolean SHOW_BOUNDING_BOX = true;
	
	/** The X-Coordinate of the render Object */
	protected int x;
	
	/** The Y-Coordinate of the render Object */
	protected int y;
	
	/** The zIndex is responsible for how much in front an
	 * object will be drawn. The higher the Index is, the more on top
	 * the object will be drawn
	 */
	protected int zIndex;
	
	/** Saves the type of the object */
	public static String thisType;

	/** Sets the coords and the zIndex for the Object
	 * 
	 * @param x
	 * 				The x-coordinate of the object
	 * @param y
	 * 				The y-coordinate of the object
	 * @param zIndex
	 * 				The zIndex of the object
	 */
	public RenderObject(int x, int y, int zIndex) {
		this.x = x;
		this.y = y;
		this.zIndex = zIndex;
	}

	/** Checks if this equals an object
	 * @param obj
	 * 				The object to which this should be compared
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		return false;
	}
	
	/** Gets the center-coordinate of the object
	 * 
	 * @return The x-coordinate of the center of the object
	 */
	public int getCenterX() {
		return x + getWidth() / 2;
	}
	
	/** Gets the center.coordinate of the object
	 * 
	 * @return The y-coordinate of the center of the object
	 */
	public int getCenterY() {
		return y + getHeight() / 2;
	}
	
	public abstract int getWidth();
	
	public abstract int getHeight();
	
	/**
	 * Internal function to render objects.
	 * 
	 * @param g
	 *            The graphics context to render on.
	 */
	public final void renderInternal(Graphics g) {

		// Perform the actual rendering.
		render(g);

		// Perform the debug rendering.
		
		if (SHOW_BOUNDING_BOX) {

			// Store the current color.
			Color color = g.getColor();

			g.setColor(Color.magenta);
			g.drawRect(x, y, getWidth(), getHeight());

			// Restore the color.
			g.setColor(color);
		}
	}
	
	/**
	 * Render this object on the Canvas' graphic area.
	 * 
	 * @param g
	 *            The graphics object to render itself on.
	 */
	public abstract void render(Graphics g);
	
	@Override
	public int compareTo(RenderObject o) {
		return zIndex - o.zIndex;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getzIndex() {
		return zIndex;
	}

	public void setzIndex(int zIndex) {
		this.zIndex = zIndex;
	}

	public String getType() {
		return null;
	}
	
	public Object getSet() {
		return this;
	}
	
}
