package IOactions.SecAction;

import java.io.File;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;

public class PostWait {

	private String imagePath;
	private int timeInSeconds;
	private double similarity;
	private static int implicityWait = 20000;
	
	private Mouse mouse = new DesktopMouse();
	private Keyboard keyboard = new DesktopKeyboard();

	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getTimeInSeconds() {
		return timeInSeconds;
	}

	public void setTimeInSeconds(int timeInSeconds) {
		this.timeInSeconds = timeInSeconds;
	}

	public double getSimilarity() {
		return similarity;
	}

	public void setSimilarity(double similarity) {
		this.similarity = similarity;
	}
	
	public void click(){
		howToclick(Enum.LEFT_CLICK);
	}
	
	public void rightClick(){
		howToclick(Enum.RIGHT_CLICK);
	}
	
	public void doubleClick(){
		howToclick(Enum.DOUBLE_CLICK);
	}
	
	private void howToclick(Enum click) {
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);
	
		ScreenRegion aux = myDesktop.wait(imageTarget, implicityWait);

		switch (click) {
		case RIGHT_CLICK:
			mouse.rightClick(aux.getCenter());
			break;
		case LEFT_CLICK:
			mouse.click(aux.getCenter());
			break;
		case DOUBLE_CLICK:
			mouse.doubleClick(aux.getCenter());
			break;
		}

	}
	
	public void hover(){
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);
	
		ScreenRegion aux = myDesktop.wait(imageTarget, implicityWait);
		mouse.drop(aux.getCenter());
		aux = myDesktop.wait(imageTarget, implicityWait);
	}
	
	public PostType type(String text){
		click();
		keyboard.type(text);
		
		return null;
	}
}
