import org.junit.Test;

import IOactions.ScreenDriver;


public class Testando {

	ScreenDriver driver = new ScreenDriver();
	
	@Test
	public void LoadDriver() {
		driver.findImage("toStartTest.png", 0.80).type("load HpLdapDriver.efi");
		driver.waitFor("Img/toStartTest.png", 10);
	}
}
