package main.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


import main.log.Log;

/**
 * {@link ImageObject}s are used to represent objects that render an image from
 * the filesystem on the canvas.
 */
public class ImageObject extends RenderObject {
	
	// The image to render.
	private BufferedImage image;

	/**
	 * Create a new ImageObject that can be rendered on the canvas based on an
	 * image from the file system.
	 * 
	 * @param x
	 *            The initial x coordinate.
	 * @param y
	 *            The initial y coordinate.
	 * @param zIndex
	 *            The initial zIndex.
	 * @param collision
	 *            Can other objects collide with this one?
	 * @param filename
	 *            The filename of the image to render.
	 */
	public ImageObject(int x, int y, int zIndex, boolean collision, String filename) {
		
		// Call the constructor of the parent class.
		super(x, y, zIndex);
		
		// Check if the provided file name makes sense.
		if (filename == null) {
			throw new IllegalArgumentException("The filename may not be null!");
		}
		
		try {
			// Try to load the image from the fail system.
			image = ImageIO.read(new File(filename));
			
		} catch (IOException e) {
			// This branch is only executed if an exception was thrown inside
			// the "try{ ... }" block.
			image = null;
			Log.error("Failed to load image: " + filename);
			e.printStackTrace();
		}
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(image, x, y, null);
	}

	@Override
	public int getWidth() {
		return image.getWidth();
	}

	@Override
	public int getHeight() {
		return image.getHeight();
	}

	@Override
	public int compareTo(RenderObject o) {
		// TODO Auto-generated method stub
		return 0;
	}

}