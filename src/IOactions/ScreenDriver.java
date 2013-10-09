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

import com.googlecode.javacv.cpp.avfilter.AVFilterPic.Free;

import IOactions.SecAction.PostFind;
import IOactions.SecAction.PostWait;

public class ScreenDriver {

	public Mouse mouse = new DesktopMouse();
	public Keyboard keyboard = new DesktopKeyboard();
	
	PostFind postFind;
	PostWait postWait;
	
	static int implicityWait = 20000;
	int timeResult = 0;
	double defaultSimilarity = 0.70;

	public PostWait waitFor(String imagePath, int timeInSeconds,double similarity) {
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);
		
		timeResult = timeInSeconds * 1000;
		myDesktop.wait(imageTarget, timeResult);
		myDesktop.find(imageTarget);

		//PostWait
		postWait = new PostWait();
		postWait.setImagePath(imagePath);
		postWait.setTimeInSeconds(timeInSeconds);
		postWait.setSimilarity(similarity);
		return postWait;
	}

	public PostWait waitFor(String imagePath, int timeInSeconds) {
		postWait = waitFor(imagePath, timeInSeconds, defaultSimilarity);

		return postWait;
	}
	
	public void type(String text){
		keyboard.type(text);
	}

	public PostFind findImage(String imagePath, double similarity) {
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);

		myDesktop.wait(imageTarget, implicityWait);
		myDesktop.find(imageTarget);

		// PosFind
		postFind = new PostFind();
		postFind.setImagePath(imagePath);
		postFind.setSimilarity(similarity);
		return postFind;
	}

	public PostFind findImage(String imagePath) {
		postFind = findImage(imagePath, defaultSimilarity);

		return postFind;
	}

	public void findHightLight(String imagePath) {
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(defaultSimilarity);

		ScreenRegion myScreen = myDesktop;
		myScreen.wait(imageTarget, implicityWait);
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
		assertImageExists(expectedImagePath, similarity, implicityWait);
	}

	public void assertImageExists(String expectedImagePath) {
		assertImageExists(expectedImagePath, defaultSimilarity, implicityWait);
	}

	private void screenShot() {
		keyboard = new DesktopKeyboard();
		keyboard.type(Key.PAUSE);
	}
	
	
}
