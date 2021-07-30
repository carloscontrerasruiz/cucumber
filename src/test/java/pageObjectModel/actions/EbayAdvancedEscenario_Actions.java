package pageObjectModel.actions;

import org.openqa.selenium.WebDriver;

import pageObjectModel.elements.EbayAdvancedEscenarios_Elements;
import steps.globalhooks.CommonSteps;

public class EbayAdvancedEscenario_Actions {
	
	private WebDriver driver;
	
	private EbayAdvancedEscenarios_Elements elements;

	public EbayAdvancedEscenario_Actions(CommonSteps commonSteps) {
		this.driver = commonSteps.getDriver();
		elements = new EbayAdvancedEscenarios_Elements(driver);
	}
	
	public void clickAdvancedSearchBtn(){
		elements.searchBtn.click();
	}
	
	public void searchString(String paramsSearch) {
		elements.searchString.sendKeys(paramsSearch);
	}
	
	public void excludeString(String paramsExclude) {
		elements.excludeString.sendKeys(paramsExclude);
	}
	
	public void minPrice(String minPrice) {
		elements.minPrice.sendKeys(minPrice);
	}
	
	public void maxPrice(String maxPrice) {
		elements.maxPrice.sendKeys(maxPrice);
	}
	
	public void clickEbayLogo() {
		elements.ebayLogo.click();
	}
}
