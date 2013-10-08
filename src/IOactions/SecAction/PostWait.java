package IOactions.SecAction;

import java.io.File;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;

public class PostWait {

	String imagePath;
	int timeInSeconds;
	double similarity;
	Mouse mouse;
	
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
		mouse = new DesktopMouse();
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);
	
		ScreenRegion aux = myDesktop.wait(imageTarget, 5000);
		mouse.click(aux.getCenter());
	}
	
	public void rightClick(){
		mouse = new DesktopMouse();
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);
	
		ScreenRegion aux = myDesktop.wait(imageTarget, 5000);
		mouse.rightClick(aux.getCenter());
	}
	
	public void doubleClick(){
		mouse = new DesktopMouse();
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);
	
		ScreenRegion aux = myDesktop.wait(imageTarget, 5000);
		mouse.doubleClick(aux.getCenter());
	}
	
	public void hover(){
		mouse = new DesktopMouse();
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);
	
		ScreenRegion aux = myDesktop.wait(imageTarget, 5000);
		mouse.drop(aux.getCenter());
	}
}
