package Config;

import MainAction.ScreenDriver;

public class DefaultSimilarityConfig {
	
	public void defaultSimilarity(double similarityValue){
		ScreenDriver driver = new ScreenDriver();
		driver.setDefaultSimilarity(similarityValue);
	}

}
