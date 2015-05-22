package fyp;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class awtConfig extends Configuration {
	public Frame mainFrame;
	public String frameName;
	public int width, height;
	public GridLayout myGrid;
	public WindowAdapter windowCloser = new WindowAdapter() {
		public void windowClosing(WindowEvent windowEvent) {
			System.exit(0);
		}
	};
	public Label headerLabel, statusLabel;
	public Panel controlPanel;
	public awtConfig(String frameName, int width, int height, GridLayout myGrid,
			Label headerLabel, Label statusLabel, Panel controlPanel) {
		super();
		this.frameName = frameName;
		this.width = width;
		this.height = height;
		this.myGrid = myGrid;
		this.headerLabel = headerLabel;
		this.controlPanel = controlPanel;
		this.statusLabel = statusLabel;
	}
	
	
	
}
