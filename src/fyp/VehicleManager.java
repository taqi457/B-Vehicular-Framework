package fyp;

import java.util.HashMap;
import java.util.Observable;

public class VehicleManager extends Observable implements Runnable {
	
	private HashMap<Integer, Vehicle> vehicleList = new HashMap<Integer, Vehicle>();
	
	public void updateList() {
		setChanged();
		notifyObservers();
	}
	
	public VehicleManager () {
		run();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			//this is exactly the line that will be subsituted by the code ali should be writing;
			int carId = 1;
			double RSSI = 12;
			
			Thread.sleep(250);
			updateList();
		}
	}
	
	}
	
	
	
