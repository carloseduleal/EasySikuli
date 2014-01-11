package MainAction.SecondaryAction;

import java.io.File;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;

import Enum.ClickType;

public class PostFind {

	private String imagePath;
	private double similarity;
	private int implicityWait = 20000;
	
	PostType postType;
	private Mouse mouse = new DesktopMouse();
	private Keyboard keyboard = new DesktopKeyboard();

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
	
	public void rightClick() {
		howToclick(ClickType.RIGHT_CLICK);
	}

	public void click() {
		howToclick(ClickType.LEFT_CLICK);

	}

	public void doubleClick() {
		howToclick(ClickType.DOUBLE_CLICK);

	}

	private void howToclick(ClickType click) {
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

	public PostType type(String text) {
		postType = new PostType();
		click();
		keyboard.type(text);
		
		return postType;
	}

	public void hover(int timeInSeconds) {
		int timeResult;
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

		ScreenRegion myDragRegion = myDragScreen.wait(targetDragImage,
				implicityWait);
		mouse.drag(myDragRegion.getCenter());

		ScreenRegion myDropScreen = new DesktopScreenRegion();
		File dropImage = new File(finalImagePath);
		Target targetDropImage = new ImageTarget(dropImage);
		targetDropImage.setMinScore(similarity);

		ScreenRegion myDropRegion = myDropScreen.wait(targetDropImage,
				implicityWait);
		mouse.drop(myDropRegion.getCenter());

		PostDragTo dragTo = new PostDragTo();

		dragTo.setImagePath(finalImagePath);
		dragTo.setSimilarity(similarity);
		return dragTo;
	}

}
