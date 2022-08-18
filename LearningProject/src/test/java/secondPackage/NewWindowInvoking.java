package secondPackage;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowInvoking {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"Setup"+File.separator+"chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		/*
		 * till now we can handle multiple windows/tabs but now with selenium 4 we can
		 * invoke new windows/tabs with below described feature
		 * line no 28 will open a new tab/window (whatever you will give) and we will hit our desired URLs in this tab by window handling
		 */
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windows=driver.getWindowHandles();
		Iterator <String> it =windows.iterator();
		String parentWindow =it.next();
		String childWindow= it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		
		
		String courseName =driver.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]")).get(2).getText();
		
	
		System.out.println(courseName);
		driver.switchTo().window(parentWindow);
		WebElement name = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));
		name.sendKeys(courseName);
		
		// Taking screenshot of specific element
		File ss= name.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\screenshots\\"+"name.png";
		FileUtils.copyFile(ss, new File(destinationFile));
		
		//taking height and width of element
		System.out.println("Heigth is "+name.getRect().getDimension().getHeight() );
		System.out.println("Width is "+name.getRect().getWidth());
		//driver.close();
	}

}
