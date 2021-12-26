package TestBase;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class Base {
 protected WebDriver driver;
 
 @BeforeTest
 public void initializeDriver() throws Exception{
	 String host="localhost";
	 DesiredCapabilities dc= DesiredCapabilities.chrome();
	 if(System.getProperty("BROWSER")!=null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
		
		 dc=DesiredCapabilities.firefox();
	 }
	 if(System.getProperty("HUB_HOST")!=null){
		 System.out.println("inside hub)");
		 host=System.getProperty("HUB_HOST");
	 }
	 String completeUrl="http://"+host+":4444/wd/hub";
	 this.driver=new RemoteWebDriver(new URL(completeUrl), dc);
 }
 @AfterTest
 public void quitDriver(){
	 this.driver.quit();
 }
 
}
