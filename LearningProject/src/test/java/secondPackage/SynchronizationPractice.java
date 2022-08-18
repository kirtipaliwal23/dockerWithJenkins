package secondPackage;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.Timeout;
import firstPackage.Base;

public class SynchronizationPractice extends Base{
	public WebDriver driver;
	

	
	@BeforeTest
	public void initializeDriver() throws Exception{
		 driver =  initializeWebDriver();
	}
	@Test
	public void login() throws Exception {
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//div[@class='form-check-inline']/label[2]/span[@class='checkmark']")).click();
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//button[contains(@class,'btn-success')]"))).click();
	//driver.switchTo().alert().accept();
//	driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	//	((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@class='btn btn-success']")));	
		Select s = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		s.selectByValue("consult");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.id("signInBtn")).submit();
		
		WebDriverWait d=new WebDriverWait(driver,Duration.ofSeconds(20));
		d.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()='Shop Name']"))));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//p[contains(@class,'text-center')]")));

		
	List<WebElement> L = driver.findElements(By.xpath("//button[text()='Add ']"));
		for(WebElement e : L) {
			e.click();
		}
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.partialLinkText("Checkout")));
		driver.findElement(By.partialLinkText("Checkout")).click();
	}
    
}
