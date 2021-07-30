package pageObjectModel.actions;

import org.openqa.selenium.WebDriver;

import steps.globalhooks.CommonSteps;

public class CommonActions {

	private WebDriver driver;

	public CommonActions(CommonSteps commonSteps) {
		this.driver = commonSteps.getDriver();
	}
	
	public void goToUrl(String url) {
		driver.get(url);
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
