package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import main.log.Log;
import main.objects.RenderObject;

@SuppressWarnings("serial")
public class Canvas extends JPanel {
	
	private Dimension SIZE = new Dimension(1000,1200);
	
	private static final int FPS = 30;
	
	private Planner planner;

	public Canvas(Planner planner) {
		
		setPreferredSize(SIZE);
		
		this.planner = planner;
		
		Timer timer = new Timer((int) (1000.0 / FPS), new ActionListener() {

			// This function is called with the specified frequency.
			@Override
			public void actionPerformed(ActionEvent e) {
				// Repaint the canvas object.
				Canvas.this.repaint();
			}
		});
		
		timer.start();
		
	}

	public void paintComponent(Graphics g) {

		Log.debug("Painting the canvas.");

		// Let the swing framework do it's drawing of the JPanel first.
		super.paintComponent(g);

		// The following two commands draw the background:

		// Set the color of the "pen". This color will be used in the following
		// drawing commands.
		g.setColor(Color.white);

		// Draw a rectangle with the size of the canvas. Therefore, this draws a
		// "background".
		g.fillRect(0, 0, SIZE.width, SIZE.height);

		// Get all objects, and sort them according to their zIndex.
		List<RenderObject> plannerObjects = new ArrayList<RenderObject>(planner.getObjectsToRender());
	Collections.sort(plannerObjects);
		
		// Render all objects.
		for (RenderObject object : plannerObjects) {
			object.renderInternal(g);
		}
		
	}
	
}
