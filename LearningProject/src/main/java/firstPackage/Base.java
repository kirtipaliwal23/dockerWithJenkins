package firstPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
    public WebDriver driver;
    public Properties prop;
 
	public WebDriver initializeWebDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+File.separator+"Resources"+File.separator+"data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			
			/* To run chrome in headless mode 
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("headless");
			
			OR
			options.addArguments("-headless");
			driver = new ChromeDriver(options);
			When running in headless make sure you have latest version of selenium
			*/
			//browserName=="chrome"
			// we cant use == here if we are extracting value from a property 
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"Setup"+File.separator+"chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if (browserName.equals("firefox")) {
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+File.separator+"Setup"+File.separator+"chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE")) {
			//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+File.separator+"Setup"+File.separator+"chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenShotPath(String methodName, WebDriver driver) throws Exception {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File ss =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\screenshots\\"+methodName+".png";
		FileUtils.copyFile(ss,new File(destinationFile));
		return destinationFile;
	}
	
}
