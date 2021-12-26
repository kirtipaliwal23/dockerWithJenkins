package TestBase;

import org.openqa.selenium.WebDriver;

public class ComponentBase {
	protected final WebDriver driver;
	protected ComponentBase(WebDriver driver) {
		this.driver = driver;
	}

	
}
