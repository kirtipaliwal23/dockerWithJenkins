package firstPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GmailHomePage {
	/* webelements are identified by @FindBy Annotation 
	 * @FindBy will convert all this code to driver.findELement lines
	 * when you initialize page factory with initElements method as this method
	 * will take driver as an argument and this driver will be used to create
	 * driver.findELement statement */
	
	//driver.findElement(By.xpath("//div[text()='solution']")).click();
	
	@FindBy(xpath="//div[text()='solution']")
	WebElement sol1;
	
	//OR
	
	@FindBy(how=How.XPATH,using="//div[text()='solution']")
	WebElement sol;
	
	public GmailHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loginGmail() {
		sol1.click();
	}
}
