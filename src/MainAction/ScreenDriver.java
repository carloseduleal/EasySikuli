package MainAction;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
import Config.DynamicVariables;
import MainAction.SecondaryAction.PostFind;
import MainAction.SecondaryAction.PostType;
import MainAction.SecondaryAction.PostWait;

public class ScreenDriver {

	public Mouse mouse = new DesktopMouse();
	public Keyboard keyboard = new DesktopKeyboard();
	
	private PostType postType;
	private PostFind postFind;
	private PostWait postWait;
	private static DynamicVariables config = new DynamicVariables();
	
	public DynamicVariables config (){
		return config;
	}

	/**
	 * This method waits the specified time for an element (image) disappear from
	 * the screen.
	 * 
	 * @param imagePath
	 *            path to the image to verified on the screen;
	 * @param timeoutInSeconds
	 *            the limit of time that this function will wait for the image;
	 * @param similarity
	 *            similarity degree to be used on the comparison between the
	 *            target image and the screen (min 0.01, max 0.99);
	 * @throws InterruptedException
	 */
	public boolean waitDisappear(final String imagePath,
			final int timeoutInSeconds, final double similarity)
			throws InterruptedException {
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);

		ScreenRegion myScreen = myDesktop;
		int currentTime = 0;
		do {
			myScreen = myDesktop.find(imageTarget);
			Thread.sleep(1000);
			currentTime++;
		} while ((myScreen != null) && (currentTime <= timeoutInSeconds));
		if(myScreen != null){
			return false;
		}
		return true;
	}

	/**
	 * This method waits the specfied time for an element (image) disappear from
	 * the screen.
	 * 
	 * @param imagePath
	 *            path to the image to verified on the screen;
	 * @param timeoutInSeconds
	 *            the limit of time that this function will wait for the image;
	 * @throws InterruptedException
	 */
	public void waitDisappear(String imagePath, int timeoutInSeconds)
			throws InterruptedException {
		waitDisappear(imagePath, timeoutInSeconds, config.getDefaultSimilarity());
	}

	/**
	 * This method waits the specified time for an element (image) to show up on
	 * the screen.
	 * 
	 * @param imagePath
	 *            path to the image to verified on the screen;
	 * @param timeInSeconds
	 *            wait time in seconds;
	 * @param similarity
	 *            similarity degree to be used on the comparison between the
	 *            target image and the screen (min 0.01, max 0.99);
	 * @return postWait object returned including the parameters informed
	 */
	public PostWait waitFor(final String imagePath, final int timeInSeconds,
			final double similarity) {
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);
		int timeResult = 0;
		
		timeResult = timeInSeconds * 1000;
		myDesktop.wait(imageTarget, timeResult);
		ScreenRegion ret = myDesktop.find(imageTarget);
		if (ret == null){
			return null;
		}
		// PostWait
		postWait = new PostWait();
		postWait.setImagePath(imagePath);
		postWait.setTimeInSeconds(timeInSeconds);
		postWait.setSimilarity(similarity);
		return postWait;
	}

	/**
	 * This method waits the specified time for an element (image) to show up on
	 * the screen.
	 * 
	 * @param imagePath
	 *            path to the image to verified on the screen;
	 * @param timeInSeconds
	 *            wait time in seconds;
	 * @return postWait object returned including the parameters informed
	 */
	public PostWait waitFor(final String imagePath, final int timeInSeconds) {
		postWait = new PostWait();
		postWait = waitFor(imagePath, timeInSeconds, config.getDefaultSimilarity());
		if (postWait == null){
			return null;
		}
		
		return postWait;
	}

	/**
	 * This method write any specified text where the focus is setted.
	 * 
	 * @param text
	 *            the text that will be written.
	 */
	public PostType type(final String text) {
		postType = new PostType();
		keyboard.type(text);

		return postType;
	}

	/**
	 * This method search for an element(image) in the current screen. So, this
	 * method is the initial point to other actions, like:
	 * click(),doubleClick(), type(), and others.
	 * 
	 * @param imagePath
	 *            path to the image to verified on the screen;
	 * @param similarity
	 *            similarity degree to be used on the comparison between the
	 *            target image and the screen (min 0.01, max 0.99);
	 * 
	 * @return postFind object returned including the parameters informed
	 */
	public PostFind findImage(final String imagePath, final double similarity) {
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);

		myDesktop.wait(imageTarget, config.getImplicityWait());
		ScreenRegion ret = myDesktop;
		ret = myDesktop.find(imageTarget);
		if (ret == null){
			return null;
		}

		postFind = new PostFind();
		postFind.setImagePath(imagePath);
		postFind.setSimilarity(similarity);
		return postFind;
	}

	/**
	 * This method search for an element(image) in the current screen. So, this
	 * method is the initial point to other actions, like:
	 * click(),doubleClick(), type(), and others.
	 * 
	 * @param imagePath
	 *            path to the image to verified on the screen;
	 * 
	 * @return postFind object returned including the parameters informed
	 */
	public PostFind findImage(String imagePath) {
		postFind = new PostFind();
		
		postFind = findImage(imagePath, config.getDefaultSimilarity());
		if (postFind == null){
			return null;
		}
		
		return postFind;
	}

	/**
	 * This method should help the user by trying to find a target image on the
	 * Screen and surrounds it with a red box;
	 * 
	 * @param imagePath
	 *            path (in the current project) to the image to be found;
	 */
	public boolean findHightLight(String imagePath) {
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(config.getDefaultSimilarity());

		ScreenRegion myScreen = myDesktop;
		myScreen.wait(imageTarget, config.getImplicityWait());
		myScreen = myDesktop.find(imageTarget);
		if (myScreen == null) {
			return false;
		}
		Canvas canvas = new DesktopCanvas();
		canvas.addBox(myScreen).withLineWidth(4);
		canvas.display(5);
		return true;
	}

	/**
	 * This method only press the PAUSE key. The PAUSE is the Wink (app that
	 * receive screenShots and save as PDF) hotkey.
	 */
	private void screenShot() {
		keyboard.type(Key.PAUSE);
	}

	/**
	 * This method open an specified application (.exe or .bat format)
	 * 
	 * @param appAddress
	 *            the full path of the application.
	 *            (example:"C:\\Users\\example.exe")
	 * 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public Process openApplication(String appAddress) throws IOException, InterruptedException {
		Process ret = Runtime.getRuntime().exec(appAddress);
		return ret;
	}
	
	/**
	 * This method close the specified application opened 
	 * 
	 * @param processToClose
	 * 			the openApplication's return
	 */
	public void closeApplication(Process processToClose){
		processToClose.destroy();
	}

	/**
	 * This method open the default browse and receive his URL as parameter.
	 * 
	 * @param browseUrl
	 *            the URL page that the browse will receive
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public void openDefaultBrowser(String URL) throws URISyntaxException,
			IOException {
		URI url = new URI(URL);
		java.awt.Desktop.getDesktop().browse(url);
	}

	public void openTxtFile(String fileAddress) throws IOException {
		File file = new File(fileAddress);
		java.awt.Desktop.getDesktop().edit(file);
	}

	public void pressEnter() {
		keyboard.type(Key.ENTER);
	}
}
