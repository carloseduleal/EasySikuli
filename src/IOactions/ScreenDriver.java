package IOactions;

import java.io.File;

import junit.framework.Assert;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Key;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;

import IOactions.SecAction.PostFind;
import IOactions.SecAction.PostWait;

public class ScreenDriver {

	Mouse mouse = new DesktopMouse();
	Keyboard keyboard = new DesktopKeyboard();
	double defaultSimilarity = 0.70;
	PostFind find;
	PostWait wait;

	public PostWait waitFor(String imagePath, int timeInSeconds,
			double similarity) {
		int timeResult = 0;
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);

		ScreenRegion aux = myDesktop;
		timeResult = timeInSeconds * 1000;
		aux.wait(imageTarget, timeResult);
		aux = myDesktop.find(imageTarget);

		try {
			if (aux == null)
				;
		} catch (Exception e) {
			// TODO: handle exception
		}

		wait = new PostWait();
		wait.setImagePath(imagePath);
		wait.setTimeInSeconds(timeInSeconds);
		wait.setSimilarity(similarity);
		return wait;
	}

	public PostWait waitFor(String imagePath, int timeInSeconds) {
		waitFor(imagePath, timeInSeconds, defaultSimilarity);

		wait = new PostWait();
		wait.setImagePath(imagePath);
		wait.setTimeInSeconds(timeInSeconds);
		wait.setSimilarity(defaultSimilarity);
		return wait;
	}
	
	public void type(String text){
		keyboard.type(text);
	}

	public PostFind findImage(String imagePath, double similarity) {
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);

		ScreenRegion myScreen = myDesktop;
		myScreen = myDesktop.find(imageTarget);
		myScreen.getCenter();

		// PosFind
		find = new PostFind();
		find.setImagePath(imagePath);
		find.setSimilarity(similarity);
		return find;
	}

	public PostFind findImage(String imagePath) {
		findImage(imagePath, defaultSimilarity);

		find = new PostFind();
		find.setImagePath(imagePath);
		find.setSimilarity(defaultSimilarity);
		return find;
	}

	public void findHightLight(String imagePath) {
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(defaultSimilarity);

		ScreenRegion myScreen = myDesktop;
		myScreen = myDesktop.find(imageTarget);

		Canvas canvas = new DesktopCanvas();
		canvas.addBox(myScreen).withLineWidth(4);
		canvas.display(5);
	}

	public void assertImageExists(String expectedImagePath, double similarity,
			int timeInSeconds) {
		int timeResult;
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(expectedImagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);

		ScreenRegion myScreen = myDesktop;
		timeResult = timeInSeconds * 1000;
		myScreen.wait(imageTarget, timeResult);
		myScreen = myDesktop.find(imageTarget);
		if (myScreen == null) {
			screenShot();
		}
		Assert.assertNotNull(myScreen);
	}

	public void assertImageExists(String expectedImagePath, double similarity) {
		assertImageExists(expectedImagePath, similarity, 20);
	}

	public void assertImageExists(String expectedImagePath) {
		assertImageExists(expectedImagePath, defaultSimilarity, 20);
	}

	public void screenShot() {
		keyboard = new DesktopKeyboard();
		keyboard.type(Key.PAUSE);
	}
}
