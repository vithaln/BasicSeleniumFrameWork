package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterProductDataObjects extends TestBase {

	public EnterProductDataObjects() {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//input[@id='startdate']")
	WebElement date_StartDate;
	
	@FindBy(xpath = "//select[@id='insurancesum']")
	WebElement dd_InsuranceSum;

	@FindBy(xpath = "//select[@id='damageinsurance']")
	WebElement dd_DamageInsurance;
	
////optional products
	@FindBy(xpath = "//input[@name='Optional Products[]']/parent::label")
	List<WebElement> chk_optionalProducts;
	
	@FindBy(id="nextselectpriceoption")
	WebElement bt_nextselectpriceoption;
	/* HARD CODED Values
	 * 
	public void enterProductData() throws Exception {
		date_StartDate.sendKeys("12/6/9635");
		cm.getDropDownOptions(dd_InsuranceSum, "5.000.000,00");
		cm.getDropDownOptions(dd_DamageInsurance, "Full Coverage");
		cm.selectCheckBoxes(chk_optionalProducts, "Euro Protection");
	}
	*/
	
	public void enterProductData(HashMap<String, String> testData) throws Exception {
		date_StartDate.sendKeys(testData.get("Product_startdate").toString());
		cm.getDropDownOptions(dd_InsuranceSum, testData.get("Product_insurancesum"));
		cm.getDropDownOptions(dd_DamageInsurance, testData.get("Product_damageinsurance"));
		cm.selectCheckBoxes(chk_optionalProducts, testData.get("Product_OptionalProducts"));
	}
	
	public void clickOnNextButton() {
		bt_nextselectpriceoption.click();
	}
}
