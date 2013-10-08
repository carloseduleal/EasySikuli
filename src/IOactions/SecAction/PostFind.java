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

public class PostFind {

	String imagePath;
	double similarity;
	Mouse mouse;
	Keyboard keyboard;
	int implicityWait = 20000;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public double getSimilarity() {
		return similarity;
	}

	public void setSimilarity(double similarity) {
		this.similarity = similarity;
	}
	
	public void click() {
		mouse = new DesktopMouse();
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);

		ScreenRegion aux = myDesktop.wait(imageTarget, implicityWait);
		mouse.click(aux.getCenter());
	}

	public void type(String text) {
		keyboard = new DesktopKeyboard();
		click();
		keyboard.type(text);
	}
	
	public void rightClick() {
		mouse = new DesktopMouse();
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);

		ScreenRegion aux = myDesktop.wait(imageTarget, implicityWait);
		mouse.rightClick(aux.getCenter());

	}

	public void doubleClick() {
		mouse = new DesktopMouse();
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);

		ScreenRegion aux = myDesktop.wait(imageTarget, implicityWait);
		mouse.doubleClick(aux.getCenter());
	}

	public void hover(int timeInSeconds) {
		int timeResult;
		mouse = new DesktopMouse();
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);

		timeResult = timeInSeconds * 1000;
		
		ScreenRegion aux = myDesktop.wait(imageTarget, timeResult);
		mouse.drop(aux.getCenter());
		aux = myDesktop.wait(imageTarget, timeResult);
	}

	public PostDragTo dragTo(String finalImagePath) {
		ScreenRegion myDragScreen = new DesktopScreenRegion();
		File dragImage = new File(imagePath);
		Target targetDragImage = new ImageTarget(dragImage);
		targetDragImage.setMinScore(similarity);

		ScreenRegion myDragRegion = myDragScreen.wait(targetDragImage, implicityWait);
		mouse.drag(myDragRegion.getCenter());

		ScreenRegion myDropScreen = new DesktopScreenRegion();
		File dropImage = new File(finalImagePath);
		Target targetDropImage = new ImageTarget(dropImage);
		targetDropImage.setMinScore(similarity);

		ScreenRegion myDropRegion = myDropScreen.wait(targetDropImage, implicityWait);
		mouse.drop(myDropRegion.getCenter());
		
		PostDragTo dragTo = new PostDragTo();
		
		dragTo.setImagePath(finalImagePath);
		dragTo.setSimilarity(similarity);
		return dragTo;
	}
}
