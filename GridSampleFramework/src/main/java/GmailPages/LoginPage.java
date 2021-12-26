package GmailPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import TestBase.ComponentBase;

public class LoginPage extends ComponentBase {
	@FindBy(how = How.XPATH, using = "//a[text()='Sign in']")
	WebElement signIn_Button;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void navigateToHomePage() {
		driver.get(
				"https://www.google.com/search?q=gmail+login&rlz=1C1GCEU_enIN904IN904&oq=gmail&aqs=chrome.0.69i59j69i57j0i433l3j69i60l2j69i61.986j0j7&sourceid=chrome&ie=UTF-8");
	}

	public void clickSignIn() throws Exception {
	Thread.sleep(2000);
		signIn_Button.click();
	}
}
