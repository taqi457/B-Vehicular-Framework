package fyp;

public abstract class RSSICalculator implements _DistFinder {
	//basic code working
	@Override
	public double findDistance(double rssi) {
		// TODO Auto-generated method stub
		//y = 2.1163x2 - 14.785x + 62.289
	    double y =  rssi*rssi*0.0034;
	    y=(.4125*rssi) + 12.933;
	    return y;
	}
 
}
