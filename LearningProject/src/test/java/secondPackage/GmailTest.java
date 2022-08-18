package secondPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import firstPackage.Base;
import firstPackage.GmailHomePage;

public class GmailTest extends Base{

	public WebDriver driver;
	
	//public static Logger log = LogManager.getLogger();
	
	@BeforeTest
	public void initializeDriver() throws Exception {
		driver = initializeWebDriver();
	}
	@Test
	public void loginGmail() {
		driver.get("https://gmail.com");
		GmailHomePage gmailHomePage = new GmailHomePage(driver);
		gmailHomePage.loginGmail();
		//driver.findElement(By.xpath("//div[text()='solution']")).click();
	}
	@Test
	public void logoutGmail() {
		driver.get("https://gmail.com");
		GmailHomePage gmailHomePage = new GmailHomePage(driver);
		gmailHomePage.loginGmail();
		//driver.findElement(By.xpath("//div[text()='solution']")).click();
	}
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
