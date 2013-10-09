package SystemAction;

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

}
