package secondPackage;

import java.io.File;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {
public static void main(String[] args) {
	
	ChromeOptions options = new ChromeOptions();
	//ChromeOptions class allows you to set the behaviour for your chrome browser.
	
	// if you want to bypass insecurity messages regarding sites
	options.setAcceptInsecureCerts(true);
	
	
	/*
	 * if you need to set a proxy 
	 
	 * Proxy proxy = new Proxy();
	 * proxy.setHttpProxy("ipaddress:4444"); //here define what kind of proxy you need
	 
	 * you can not write directly the value of proxy , you have to use object of proxy class
	 
	 * options.setCapability("proxy",proxy);
	 */
	
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"Setup"+File.separator+"chromedriver.exe");
	WebDriver driver = new ChromeDriver(options);
	driver.get("https://expired.badssl.com/");
	System.out.println(driver.getTitle());
}
}
