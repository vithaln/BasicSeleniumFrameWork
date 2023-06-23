package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePageObjects extends TestBase {

	public HomePageObjects() {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath =   "//div[@class='main-navigation']//a[@id='nav_motorcycle']")
	WebElement link_automobile;
	
	@FindBy(id = "nav_truck")
	WebElement link_truck;
	
	@FindBy(xpath ="//div[@class='main-navigation']//a[@id='nav_motorcycle']")
	public WebElement link_motorcycle;
	
	@FindBy(id = "nav_camper")
	WebElement link_camper;
	
	public void clickOnMotorCycle() {
		link_automobile.click();
	}
	
	
}
