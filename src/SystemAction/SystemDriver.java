package SystemAction;

import org.sikuli.script.App;

public class SystemDriver {
	

	
	public void openApplication(String appName, String appAddress){
			App application = new App(appName);
			application.open(appAddress);
	}

	public void hotkeys(){
		
	}
	
	public void disableNetwork(){
		
	}
	
	
	
}
