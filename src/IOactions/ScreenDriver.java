package IOactions;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
import org.sikuli.script.App;

import IOactions.SecAction.PostFind;
import IOactions.SecAction.PostWait;

/**
 * @author Carlos Leal
 * 
 */
public class ScreenDriver {

	public Mouse mouse = new DesktopMouse();
	public Keyboard keyboard = new DesktopKeyboard();

	private PostFind postFind;
	private PostWait postWait;

	static int implicityWait = 20000;
	int timeResult = 0;
	double defaultSimilarity = 0.70;

	public void waitDisappear(String imagePath, int timeoutInSeconds, double similarity) {
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);

		ScreenRegion myScreen = myDesktop;
			do {
				myScreen = myDesktop.find(imageTarget);
			} while (myScreen != null);
	}

	/**
<<<<<<< HEAD
	 * Método que espera, ate o tempo informado, um elemento(imagem) aparecer na
	 * tela.
	 * 
	 * @param imagePath
	 *            endereco(dentro do projeto) da imagem a ser aguardada;
	 * @param timeInSeconds
	 *            tempo de espera;
	 * @param similarity
	 *            grau de similaridade da imagem a ser aguardada (min 0.01, max
	 *            0.99);
=======
	 * This method waits the specified time for an element (image) to show up on the screen.
	 * 
	 * @param imagePath path to the image to verified on the screen; 
	 * @param timeInSeconds wait time in seconds;
	 * @param similarity similarity degree to be used on the comparison between the target image and the screen (min 0.01, max 0.99);
>>>>>>> fdbf8754e501e68ce7fb8c5995b1fea356c130d8
	 * 
	 * @return postWait object returned including the parameters informed
	 */
	public PostWait waitFor(String imagePath, int timeInSeconds,
			double similarity) {
		ScreenRegion myDesktop = new DesktopScreenRegion();
		File image = new File(imagePath);
		Target imageTarget = new ImageTarget(image);
		imageTarget.setMinScore(similarity);

		timeResult = timeInSeconds * 1000;
		myDesktop.wait(imageTarget, timeResult);
		myDesktop.find(imageTarget);

		// PostWait
		postWait = new PostWait();
		postWait.setImagePath(imagePath);
		postWait.setTimeInSeconds(timeInSeconds);
		postWait.setSimilarity(similarity);
		return postWait;
	}

	/**
<<<<<<< HEAD
	 * Método que espera, ate o tempo informado, um elemento(imagem) aparecer na
	 * tela.
	 * 
	 * @param imagePath
	 *            endereco(dentro do projeto) da imagem a ser aguardada;
	 * @param timeInSeconds
	 *            tempo de espera;
=======
	 * This method waits the specified time for an element (image) to show up on the screen.
	 * 
	 * @param imagePath path to the image to verified on the screen; 
	 * @param timeInSeconds wait time in seconds;
>>>>>>> fdbf8754e501e68ce7fb8c5995b1fea356c130d8
	 * 
	 * @return postWait object returned including the parameters informed
	 */
	public PostWait waitFor(String imagePath, int timeInSeconds) {
		postWait = waitFor(imagePath, timeInSeconds, defaultSimilarity);

		return postWait;
	}

	/**
<<<<<<< HEAD
	 * Método que escreve em qualquer campo de texto que estiver com o foco.
	 * 
	 * @param text
	 *            texto que será inserido no campo;
=======
	 * Metodo que escreve em qualquer campo de texto que estiver com o foco. 
	 * 
	 * @param text texto que serï¿½ inserido no campo;
>>>>>>> fdbf8754e501e68ce7fb8c5995b1fea356c130d8
	 */
	public void type(String text) {
		keyboard.type(text);
	}

	/**
<<<<<<< HEAD
	 * Método que procura uma imagem na tela atual e é ponto inicial para outras
	 * ações, como: click, doubleClick, type, etc.
=======
	 * Metodo que procura uma imagem na tela atual e eh ponto inicial para outras acoes, como:
	 * click, doubleClick, type, etc.
>>>>>>> fdbf8754e501e68ce7fb8c5995b1fea356c130d8
	 * 
	 * @param imagePath
	 *            endereco(dentro do projeto) da imagem a ser procurada;
	 * @param similarity
	 *            grau de similaridade da imagem a ser aguardada (min 0.01, max
	 *            0.99);
	 * 
	 * @return postFind objeto com o valor informado de todos os parametros;
	 */
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

	/**
<<<<<<< HEAD
	 * Método que procura uma imagem na tela atual e é ponto inicial para outras
	 * ações, como: click, doubleClick, type, etc.
=======
	 * Metodo que procura uma imagem na tela atual e eh ponto inicial para outras acoes, como:
	 * click, doubleClick, type, etc.
>>>>>>> fdbf8754e501e68ce7fb8c5995b1fea356c130d8
	 * 
	 * @param imagePath
	 *            endereco(dentro do projeto) da imagem a ser procurada;
	 * @return postFind objeto com o valor informado de todos os parametros;
	 */
	public PostFind findImage(String imagePath) {
		postFind = findImage(imagePath, defaultSimilarity);

		return postFind;
	}

	/**
<<<<<<< HEAD
	 * Método que funciona como debug, procura uma imagem na tela atual e
	 * contorna ela com um box de cor vermelha;
=======
	 * Metodo que funciona como debug, procura uma imagem na tela atual e contorna ela com um box de cor vermelha;
>>>>>>> fdbf8754e501e68ce7fb8c5995b1fea356c130d8
	 * 
	 * @param imagePath
	 *            endereco(dentro do projeto) da imagem a ser procurada;
	 */
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

	public void openApplication(String appAddress) {
		App.open(appAddress);
	}

	public void openDefaultBrowse(String browseUrl) throws URISyntaxException,
			IOException {
		URI url = new URI(browseUrl);
		java.awt.Desktop.getDesktop().browse(url);
	}

	public void openTxtFile(String appAddress) throws IOException {
		File file = new File(appAddress);
		java.awt.Desktop.getDesktop().edit(file);
	}

	public void pressEnter() {
		keyboard.type(Key.ENTER);
	}
}
