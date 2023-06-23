package insurarnceCalculation_motorCycl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reusableComponents.ExcelOperations;
import testBase.TestBase;

public class EndToEndTestsMotorCycle extends TestBase {
	
	ExcelOperations excel = new ExcelOperations("InsurancePremium");

	@Test (enabled = false)
	public void errorMessage_PayLoadField() {
		homePageObjects.clickOnMotorCycle();
		dataObjects.putCyclinderCapacity("33333");
		
		test.log(Status.PASS, "Cylinder capacity is filled with data: 33333");
		String actualErrorMessage= dataObjects.getErrorMessageOnCylinderCapacity();
		String expectederrorMessage = "Must be a number between 1 and 2000";
		Assert.assertEquals(actualErrorMessage, expectederrorMessage, "Error message is not as expected on cylinder capacity field.");
		
	}
	
	//this test case will fails due to Assert..
	//mannualy failled for capturing fails test cases. onTestFaillure will take screenshots.
	//but we must run test case via testng.xml file because we added listeners tag over there.
	@Test (enabled = false)
	public void errorMessage_PayLoadField1() {
		homePageObjects.clickOnMotorCycle();
		dataObjects.putCyclinderCapacity("33333");
		test.log(Status.PASS, "Cylinder capacity is filled with data: 33333");
		String actualErrorMessage= dataObjects.getErrorMessageOnCylinderCapacity();
		String expectederrorMessage = "Must be a number between 1 and 3000";
		Assert.assertEquals(actualErrorMessage, expectederrorMessage, "Error message is not as expected on cylinder capacity field.");
	}
	
	@Test(enabled = false)//for getting all dropdown options and compare with expected.
	public void verifyDropDownModel() {
		homePageObjects.clickOnMotorCycle();
		List<String> actualValues = dataObjects.getDropdownOption_model();
		test.log(Status.INFO, "Actual dd contents for model dd is: " +actualValues);
		List<String> expectedValues = Arrays.asList("– please select –", "Scooter", "Three-Wheeler", "Moped", "Motorcycle");
		test.log(Status.INFO, "Expected dd contents for model dd is: " +expectedValues);
		Assert.assertEquals(actualValues, expectedValues, "Error in Dropdown options compare at Model Dropdown");
				
	}
	
	/*
	
	//Main full TestCase
	@Test
	public void insuranceCalculates() throws Exception {
		homePageObjects.clickOnMotorCycle();
		dataObjects.enterVehicleAllData();
		dataObjects.clickOnNextButton();
		insurantData.enterInsurantData();
		insurantData.clickOnNextButton();
		productData.enterProductData();
		productData.clickOnNextButton();
		
		//verify conditions ...
		
		String expectedSilverPlanPrice="247.00";
		String actual=priceOptions.getPriceForSelectedOption("Silver");
		Assert.assertEquals(actual, expectedSilverPlanPrice);
		priceOptions.selectPriceOption("Silver");
		priceOptions.clickOnNextButton();
	}
	
	*/
	//Main full TestCase with DDT....
		@Test(dataProvider = "vehData")
		public void insuranceCalculates(Object obj1) throws Exception {
			
			HashMap<String, String> testData = (HashMap<String, String>) obj1;
//			System.out.println(testData);
			test.log(Status.INFO, "Test data used for execution is: "+ testData);
			homePageObjects.clickOnMotorCycle();
			dataObjects.enterVehicleAllData(testData);
			dataObjects.clickOnNextButton();
			insurantData.enterInsurantData(testData);
			insurantData.clickOnNextButton();
			productData.enterProductData(testData);
			productData.clickOnNextButton();
			
//			Assert.assertEquals(priceOptions.getPriceForSelectedOption("Gold"), testData.get("PriceValidation_Gold"), "Pricing for gold plan is not matching.");
//			Assert.assertEquals(priceOptions.getPriceForSelectedOption("Silver"), testData.get("PriceValidation_Silver"), "Pricing for silver plan is not matching.");
//			Assert.assertEquals(priceOptions.getPriceForSelectedOption("Platinum"), testData.get("PriceValidation_Platinum"), "Pricing for platimum plan is not matching.");
//			Assert.assertEquals(priceOptions.getPriceForSelectedOption("Ultimate"), testData.get("PriceValidation_Ultimate"), "Pricing for ultimate plan is not matching.");
			
			priceOptions.selectPriceOption(testData.get("SelectOption"));
			priceOptions.clickOnNextButton();
			
		}
		
		
		//Dataprovider method --> return object array
		@DataProvider (name = "vehData")
		public Object[][] testDataSupplier() throws Exception {
			Object[][] obj = new Object[excel.getRowCount()][1];
			for (int i = 1; i <= excel.getRowCount(); i++) {
				HashMap<String, String> testData = excel.getTestDataInMap(i);
				obj[i-1][0] = testData;
			}
			return obj;
			
		}
	
	
	
}
