package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterInsuranceData extends TestBase {

	public EnterInsuranceData() {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id="firstname")
	WebElement text_firstname;
	
	@FindBy(id="lastname")
	WebElement text_lastname;
	
	@FindBy(id="birthdate")
	WebElement date_Birth;
	//Gender-radio button
	@FindBy(xpath = "//input[@name='Gender']/parent::label")
	List<WebElement> rd_Gender;
	
	@FindBy(id="streetaddress")
	WebElement text_streetAdress;

	
	@FindBy(id="country")
	WebElement dd_Country;
	
	@FindBy(id="zipcode")
	WebElement txt_zipCode;
	
	@FindBy(id="city")
	WebElement txt_city;
	
	@FindBy(id="occupation")
	WebElement dd_occupation;
	
	//check box 
	@FindBy(xpath = "//input[@name='Hobbies']/parent::label")
	List<WebElement> chk_Hobbies;
	
	@FindBy(id="website")
	WebElement txt_website;
	
	@FindBy(id="picture")
	WebElement txt_picture;
	
	@FindBy(id="nextenterproductdata")
	WebElement btn_nextenterproductdata;
	
	/*
	//without DDT -HARD-CODED Values
	public void enterInsurantData() throws Exception {
		
		text_firstname.sendKeys("Vithal");
		text_lastname.sendKeys("Nivargi");
		date_Birth.sendKeys("10/01/1968");
		cm.selectDropDownForGnder(rd_Gender, "male");
		text_streetAdress.sendKeys("sonyal");
		cm.getDropDownOptions(dd_Country,"India");
		txt_zipCode.sendKeys("125653");
		txt_city.sendKeys("sangli");
		cm.getDropDownOptions(dd_occupation, "Employee");
		cm.selectCheckBoxes(chk_Hobbies, "Speeding,other");
		
	}
	*/	
	public void enterInsurantData(HashMap<String, String> testData) throws Exception {
	
		text_firstname.sendKeys(testData.get("Insurant_FirstName"));
		text_lastname.sendKeys(testData.get("Insurant_LastName"));
		date_Birth.sendKeys(testData.get("Insurant_birthdate").toString());
		cm.selectDropDownForGnder(rd_Gender, testData.get("Insurant_gender"));
		cm.getDropDownOptions(dd_Country,testData.get("Insurant_country"));
		txt_zipCode.sendKeys(testData.get("Insurant_zipcode"));
		cm.getDropDownOptions(dd_occupation, testData.get("Insurant_occupation"));
		//Select checkboxes for hobbies
		cm.selectCheckBoxes(chk_Hobbies, testData.get("Insurant_Hobby"));
		
	}
	
	public void clickOnNextButton() {
		btn_nextenterproductdata.click();
	}
	
	
	
}
