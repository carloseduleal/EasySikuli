package Config;

import Enum.TimeUnit;
import MainAction.ScreenDriver;

public class ImplicityWaitConfig {
	
	ScreenDriver driver = new ScreenDriver();
	
	public int implicityWait(int howManyTime, TimeUnit TimeUnit){
		
		int resultTime;
		
		switch(TimeUnit){
		
		case SECONDS:
			resultTime = (howManyTime * 1000);
			driver.setImplicityWait(resultTime);
			break;
		case MINUTES:
			resultTime = (howManyTime * 10000);
			driver.setImplicityWait(resultTime);
			break;
		case HOURS:
			resultTime = (howManyTime * 100000);
			driver.setImplicityWait(resultTime);
			break;
		}
		
		return driver.getImplicityWait();
	}

}
