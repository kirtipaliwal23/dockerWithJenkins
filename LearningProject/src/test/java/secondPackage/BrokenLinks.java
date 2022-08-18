package secondPackage;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class BrokenLinks {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub

	
		
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"Setup"+File.separator+"chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       
		/*
		 * Our agenda here is to get all links(URLs) from page and get their status by calling them
		 * Step - 1 : Get all URLs tied up with the links using selenium
		 * Step -2 :Java methods by them we can get status code of these URLs without hitting them in reality.
		 * If status code >400 then that URL is not working :link which tied to that URL is broken
		 */
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        SoftAssert a = new SoftAssert();
        List<WebElement> links =driver.findElements(By.xpath("//li[@class='gf-li']/a"));
        String url = null;
        for(WebElement e : links) {
        	url=e.getAttribute("href");
        	HttpURLConnection conn =(HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int statusCode = conn.getResponseCode();
            a.assertTrue(statusCode<400,e.getText() + " is broken link with code "+ statusCode);
            	
       

        }
       a.assertAll();
       	}

}
