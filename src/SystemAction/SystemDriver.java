package SystemAction;

import org.sikuli.script.App;

public class SystemDriver {
	
	public void openApplication(String appName, String appAddress){
			App ret;
			App application = new App(appName);
		    ret = application.open(appAddress);
	}

	public void hotkeys(){
		
	}
	
	public void disableNetwork(){
		
	}
	
	
	
}
