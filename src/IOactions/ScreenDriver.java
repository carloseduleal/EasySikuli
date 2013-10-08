package IOactions;

import java.io.File;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
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

	public PostWait waitFor(String imagePath, int timeInSeconds, double similarity) {
		int timeResult = 0;
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);

		ScreenRegion aux = myDesktop;
		timeResult = timeInSeconds * 1000;
		aux.wait(imageTarget, timeResult);
		aux = myDesktop.find(imageTarget);
		
		//PosWaitAction
		wait = new PostWait();
		wait.setImagePath(imagePath);
		wait.setTimeInSeconds(timeInSeconds);
		wait.setSimilarity(similarity);
		return wait;
	}

	public PostWait waitFor(String imagePath, int timeInSeconds) {
		wait = waitFor(imagePath, timeInSeconds, defaultSimilarity);
	
		return wait;
	}

	public PostFind findImage(String imagePath, double similarity) {
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);

		ScreenRegion myScreen = myDesktop;
		myScreen = myDesktop.find(imageTarget);
	
		Canvas canvas = new DesktopCanvas();
		canvas.addBox(myScreen).withLineWidth(3);
		canvas.display(5);
		
		//PosFind
		find = new PostFind();
		find.setImagePath(imagePath);
		find.setSimilarity(similarity);
		return find;
	}

	public PostFind findImage(String imagePath) {
		find = findImage(imagePath, defaultSimilarity);
		
		return find;
	}

}
