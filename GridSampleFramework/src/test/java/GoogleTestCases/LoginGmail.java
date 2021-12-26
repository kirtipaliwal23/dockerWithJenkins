package GoogleTestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import GmailPages.LoginPage;
import TestBase.Base;

public class LoginGmail extends Base{

	@Test
	public void loginGmail() throws Exception{
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.navigateToHomePage();
		loginPage.clickSignIn();
	}
}