package main.log.console;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import main.log.Log;
import main.log.console.gui.ConsoleArea;

@SuppressWarnings("serial")
public class ConsoleWindow extends JFrame {
	
	public ConsoleWindow() {
		super("Console");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace(Log.cs);
		}
		initGUI();
	}
	
	/**
	 * Initializes the GUI of the console
	 */
	private void initGUI() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(500, 300));
		setResizable(false);
		{
			JMenuBar bar = new JMenuBar();
			setJMenuBar(bar);
			{
				JMenu file = new JMenu("File");
				bar.add(file);
				{
					
				}
				JMenu edit = new JMenu("Edit");
				bar.add(edit);
			}
		}
		{
			ConsoleArea ca = ConsoleStream.getConsoleArea();
			
			JScrollPane sp = new JScrollPane(ca);
			getContentPane().add(sp);
		}
		pack();
		setVisible(true);
		Log.info("Console GUI loaded sucessfully.");
	}
	
}
