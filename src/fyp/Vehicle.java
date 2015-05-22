package fyp;

public abstract class Vehicle {
	private int carId; 
	private char direction;
	private double rssi;
	
	public Vehicle(int carId, char direction, double rssi) {
		this.carId = carId;
		this.direction = direction;
		this.rssi = rssi;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public void setDirection(char direction) {
		this.direction = direction;
	}
	public void setRssi(double rssi) {
		this.rssi = rssi;
	}
	public int getCarId() {
		return carId;
	}
	public char getDirection() {
		return direction;
	}
	public double getRssi() {
		return rssi;
	}
	
	
	
}
