package testBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterInsuranceData;
import pageObjects.EnterProductDataObjects;
import pageObjects.EnterVehicleDataObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionsPageObjects;
import reusableComponents.ObjectRepo;
import reusableComponents.ReadConfigFile;

public class TestBase extends ObjectRepo  {

	
	
	@BeforeClass
	public void setUp() throws IOException {
		String browser = ReadConfigFile.getPropertyValueByKey("browser");
		launchBrowserAndNavigate(browser);
		homePageObjects=new HomePageObjects();
		dataObjects=new EnterVehicleDataObjects();
		insurantData=new EnterInsuranceData();
		productData=new EnterProductDataObjects();
		priceOptions=new SelectPriceOptionsPageObjects();
	}
	
	@AfterClass
	public void closeApp() {
		//driver.quit();
	}
	
	public void launchBrowserAndNavigate(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			
			
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		else {
			System.out.println("please Enter your browser...");
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://sampleapp.tricentis.com/101/");
	}
}
