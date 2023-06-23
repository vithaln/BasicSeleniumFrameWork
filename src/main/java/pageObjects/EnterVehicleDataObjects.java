package pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class EnterVehicleDataObjects extends TestBase {

	public EnterVehicleDataObjects() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='make']")
	WebElement dd_make;

	@FindBy(xpath = "//select[@id='model']")
	WebElement dd_model;

	@FindBy(xpath = "(//input[@id='cylindercapacity'])[1]")
	WebElement txt_cylinderCapacity;

	@FindBy(xpath = "//input[@id='engineperformance']")
	WebElement txt_enginePerformanance;

	@FindBy(id = "dateofmanufacture")
	WebElement data_dataformater;

	@FindBy(xpath = "//select[@id='numberofseatsmotorcycle']")
	WebElement dd_noOfSeats;

	@FindBy(id = "listprice")
	WebElement txt_listPrice;

	@FindBy(id = "annualmileage")
	WebElement txt_annualMileage;

	@FindBy(id = "nextenterinsurantdata")
	WebElement btn_Next;

	// This is for error showing
	@FindBy(xpath = "//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
	WebElement error_cylinderCapacity;

	public void putCyclinderCapacity(String cap) {
		txt_cylinderCapacity.sendKeys(cap);
	}

	public String getErrorMessageOnCylinderCapacity() {
		return error_cylinderCapacity.getText();
	}

	public List<String> getDropdownOption_model() {

		/*
		 * repaited codes
		 * 
		 * Select os=new Select(dd_model); List<WebElement> options = os.getOptions();
		 * 
		 * List<String> actualContents=new ArrayList<String>();
		 * 
		 * for (WebElement webElement : options) { String text = webElement.getText();
		 * actualContents.add(text);
		 * 
		 * }
		 */

		List<String> actualContents = cm.getDropDownOptionsAsList(dd_model);

		return actualContents;

	}

	// drope down for make
	public List<String> getDropdownForMake() {
		return cm.getDropDownOptionsAsList(dd_make);

	}

	/*
	
	// ***enter vehicle data HARD-CODED Values
	
	public void enterVehicleAllData() throws Exception {
		cm.getDropDownOptions(dd_make, "BMW");
		cm.getDropDownOptions(dd_model, "Moped");
		txt_cylinderCapacity.sendKeys("333");
		txt_enginePerformanance.sendKeys("555");
		data_dataformater.sendKeys("12/06/1969");
		cm.getDropDownOptions(dd_noOfSeats, "2");
		txt_listPrice.sendKeys("4525");
		txt_annualMileage.sendKeys("463");

	}*/
	// ***enter vehicle data HARD-CODED Values
	
		public void enterVehicleAllData(HashMap<String, String> testData) throws Exception {
			//enter vehicle data
			
			cm.getDropDownOptions(dd_make, testData.get("Vehicle_Make"));
			cm.getDropDownOptions(dd_model, testData.get("Vehicle_Model"));
			txt_cylinderCapacity.sendKeys(testData.get("Vehicle_CylinderCapacity"));
			txt_enginePerformanance.sendKeys(testData.get("Vehicle_Enging Performance"));
			data_dataformater.sendKeys(testData.get("Vehicle_Date of Manufacture"));
			cm.getDropDownOptions(dd_noOfSeats,testData.get("Vehicle_No of Seats_motorcycle"));
			txt_listPrice.sendKeys(testData.get("Vehicle_List Price"));
			txt_annualMileage.sendKeys(testData.get("Vehicle_Annual Mileage"));

		}
	public void clickOnNextButton() {
		btn_Next.click();
	}

}
