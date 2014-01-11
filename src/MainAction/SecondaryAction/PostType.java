package MainAction.SecondaryAction;

import org.sikuli.api.robot.Key;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.desktop.DesktopKeyboard;

public class PostType {

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	Keyboard keyboard = new DesktopKeyboard();
	
	public void pressEnter(){
		keyboard.type(Key.ENTER);
	}
	
	public void pressTab(){
		keyboard.type(Key.TAB);
	}
}
