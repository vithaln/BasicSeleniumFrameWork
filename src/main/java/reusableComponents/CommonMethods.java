package reusableComponents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
	
	//select check boxes
	public void selectCheckBoxes(List<WebElement> e,String valueToBeSelect) {
		String[] checksArray = valueToBeSelect.split(",");
		//because I'm getting value separated by , from excel sheet.
		
		for(String str:checksArray) {
		for (WebElement ref : e) {
			
			if(ref.getText().equalsIgnoreCase(str)) {
				ref.click();
				break;
			}
			
		}
		}
	}
	//select radio button
	public void selectDropDownForGnder(List<WebElement> e, String valueToBeSelect)
	{
		for (WebElement ref : e) {
			
			if(ref.getText().equalsIgnoreCase(valueToBeSelect)) {
				ref.click();
				break;
			}
			
			
		}
		
	}
//common method to select dd value
	public void getDropDownOptions(WebElement e, String valueToBeSelect) throws Exception {
		Select select = new Select(e);

		try {
			select.selectByVisibleText(valueToBeSelect);
		} catch (Exception e1) {
			throw new Exception("Value is not present in dropsown for webElement: " + e + " value to select");
		}
	}

	// get dropdown options as list of string for compare
	public List<String> getDropDownOptionsAsList(WebElement element) {
		Select os = new Select(element);
		List<WebElement> list_webElement_model = os.getOptions();
		List<String> actualContents = new ArrayList<String>();

		for (WebElement ref : list_webElement_model) {
			actualContents.add(ref.getText());
		}
		return actualContents;
	}
}
