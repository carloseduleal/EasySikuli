package IOactions.SecAction;

import org.sikuli.api.robot.Keyboard;
import org.sikuli.script.Key;

public class PostDragTo {

	private double similarity;
	private String imagePath;
	
	private Keyboard keyboard;

	public double getSimilarity() {
		return similarity;
	}

	public void setSimilarity(double similarity) {
		this.similarity = similarity;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void copy() {
		keyboard.keyDown(Key.CTRL);
		keyboard.type("c");
		keyboard.keyUp(Key.CTRL);
	}

	public void delete() {
		keyboard.type(Key.DELETE);
	}

	public void hover() {

	}
}
