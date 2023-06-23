package reusableComponents;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.EnterInsuranceData;
import pageObjects.EnterProductDataObjects;
import pageObjects.EnterVehicleDataObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionsPageObjects;

public class ObjectRepo {

	public static WebDriver driver;

	public static HomePageObjects homePageObjects;
	public static EnterVehicleDataObjects dataObjects;
	public static ExtentReports extent;
	public static ExtentTest test;
	public CommonMethods cm = new CommonMethods();
	public static EnterInsuranceData insurantData;
	public static EnterProductDataObjects productData;
	public static SelectPriceOptionsPageObjects priceOptions;
}
