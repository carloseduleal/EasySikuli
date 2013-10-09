package SystemAction;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.sikuli.api.robot.Key;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.script.App;

public class SystemDriver {

	Keyboard keyboard = new DesktopKeyboard();
	
	public void openApplication(String appAddress) {
		App.open(appAddress);
	}

	public void pressEnter() {
		keyboard.type(Key.ENTER);
	}

	public void hotkeys() {

	}

	public void disableNetwork() {

	}
	
	public void openTxtFile(String appAddress) throws IOException{
		File file = new File(appAddress);
		java.awt.Desktop.getDesktop().edit(file);
	}
	
	public void openDefaultBrowse(String browseUrl) throws URISyntaxException, IOException{
		URI url = new URI(browseUrl);
		java.awt.Desktop.getDesktop().browse(url);
	}

}
