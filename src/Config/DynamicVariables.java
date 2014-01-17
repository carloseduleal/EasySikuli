package Config;

import Enum.TimeUnit;

public class DynamicVariables {
	
	private double defaultSimilarity = 0.70;
	
	public double getDefaultSimilarity() {
		return defaultSimilarity;
	}

	public void setimplicitySimilarity(int defaultSimilarity) {
		this.defaultSimilarity = defaultSimilarity;
	}
	
	public void implicitySimilarity(double similarity){
		defaultSimilarity = similarity;
	}
	
	/*****************************************/
	
	private int implicityWait = 15000;

	public int getImplicityWait() {
		return implicityWait;
	}

	public void setImplicityWait(int implicityWait) {
		this.implicityWait = implicityWait;
	}

	public int implicityWait(int howManyTime, TimeUnit TimeUnit){
		
		switch(TimeUnit){
		
		case SECONDS:
			implicityWait = (howManyTime * 1000);
			break;
		case MINUTES:
			implicityWait = (howManyTime * 10000);
			break;
		case HOURS:
			implicityWait = (howManyTime * 100000);
			break;
		}
		
		return getImplicityWait();
	}
}


