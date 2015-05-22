package fyp;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;


public class myApp extends Application  {
	
	public myApp (Configuration myConfig) {
		prepareGUI(myConfig);
	}
	
	public static void main(String[] args) {
		Configuration myConfig = new awtConfig("Test", 400, 400, new GridLayout(3,1), new Label(),new Label() ,new Panel());
		myApp app = new myApp(myConfig);
		app.start(myConfig);
	}
	// prepare your gui yourself
	public void prepareGUI(Configuration appConfig) {
		//get Every thing from config now. 
		awtConfig c = (awtConfig)appConfig;
		c.mainFrame = new Frame(c.frameName);
		c.mainFrame.setSize(c.width,c.height);
		c.mainFrame.setLayout(c.myGrid);
		c.mainFrame.addWindowListener(c.windowCloser);
	    c.headerLabel.setAlignment(Label.CENTER);
	    c.statusLabel = c.statusLabel;        
	    c.statusLabel.setAlignment(Label.CENTER);
	    c.statusLabel.setSize(350,100);
	      
	    c.controlPanel = c.controlPanel;
	    c.controlPanel.setLayout(new FlowLayout());

	    c.mainFrame.add(c.headerLabel);
	    c.mainFrame.add(c.controlPanel);
	    c.mainFrame.add(c.statusLabel);
	    c.mainFrame.setVisible(true); 
	}	
	public void start(Configuration appConfig) {
		awtConfig c = (awtConfig)appConfig;
		c.headerLabel.setText("Control in action: Canvas"); 
		c.controlPanel.add(new MyCanvas(300,300));
		c.mainFrame.setVisible(true);  
	}
	
	class MyCanvas extends Canvas {

	    public MyCanvas (int w, int h) {
	       setSize(w, h);
	    }

	    public void paint (Graphics g) {
	       Graphics2D g2;
	       g2 = (Graphics2D) g;
	       g2.drawString ("It is a custom canvas area", 70, 70);
	    }
	 }

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}



	   
	}
