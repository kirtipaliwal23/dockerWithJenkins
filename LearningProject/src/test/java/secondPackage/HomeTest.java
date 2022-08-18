package secondPackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import firstPackage.Base;

public class HomeTest extends Base{
	 public WebDriver driver;
	 //we have declared driver here because if we run mul test classes in parallel and we use single driver which is coming
	 // from base class then it will create conflicts as for every test case driver will start the browser and close the browser
	 // so if diff test cases will run it will create conflict hence we are taking driver from base class and then assigning
	 //its value to local driver variable.
	public static Logger log = LogManager.getLogger(HomeTest.class.getName());
	@BeforeTest
	public void initialize() throws Exception {
		driver = initializeWebDriver();
	}
	@Test(dataProvider = "getData")
	public void basePageNavigation(String url) throws Exception {
		
		driver.get(url);
		log.info("URL loaded");
		//driver.get(prop.getProperty("url"));
	}
	@Test
	public void print() {
		driver.get("https://amazon.com");
		log.info("Amazon");
	}
	
	@DataProvider
	public Object[][] getData() {
		//row tells that how many different data types test should run or how many times test will run
		//column stands for how many values for each test
		//Object takes total counts ; Object[total row][total column], not index.
		Object[][] data =new Object [2][1];
		data[0][0]="https://google.com";
		data[1][0]="https://facebook.com";
		return data;
	}

	@AfterTest
    public void tearDown() {
    	driver.close();
    }
}
