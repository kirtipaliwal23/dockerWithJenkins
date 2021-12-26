package GoogleTestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import GmailPages.LoginPage;
import TestBase.Base;

public class AccessGmail extends Base{

	@Test
	public void accessGmail(){
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.navigateToHomePage();
		
	}
	
}
