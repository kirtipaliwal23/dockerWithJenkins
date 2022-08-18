package secondPackage;

import java.io.File;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class fluentWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"Setup"+File.separator+"chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//div[@id='start']/button")).click();

		Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)
				).ignoring(NoSuchElementException.class);
		
		WebElement foo = w.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		    	 if(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed()) {
		    		 return driver.findElement(By.xpath("//h4[text()='Hello World!']"));
		    	 }
		    	 else {
		    		return null;
		    	 }
		      
		     }
	});
		System.out.println(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
}
}
