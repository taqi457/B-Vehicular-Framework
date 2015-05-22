package fyp;

import java.util.Observable;
import java.util.Observer;

import processing.core.*;

public abstract class ProcessingApplication extends PApplet implements Observer, _App{

	private VehicleManager vehicleManager = new VehicleManager();
	private static final long serialVersionUID = -1060367483543183808L;
	public abstract void draw();
	public abstract void setup();
	
	public void update (Observable observable, Object arg0){
		if(observable instanceof VehicleManager){
			
		}
	}
}
