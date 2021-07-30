package steps;

import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.globalhooks.CommonSteps;

public class EasyHome_Steps {
	
	WebDriver driver;
	
	public EasyHome_Steps(CommonSteps commonSteps) {
		this.driver = commonSteps.getDriver();
	}
	
	@Given("I am on Ebay Page")
	public void i_am_on_ebay_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.get("https://mx.ebay.com/");
	}

	@When("I click on Advanced Link")
	public void i_click_on_advanced_link() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("ebay Ofertas")).click();
	}

	@Then("I navigate to Advanced Search page")
	public void i_navigate_to_advanced_search_page() {
	    // Write code here that turns the phrase above into concrete actions
		String expectedUrl = "https://www.ebay.com/globaldeals";
		
		if (!expectedUrl.equals(driver.getCurrentUrl())) {
			fail("The url are not equals");
		}
	}
	
	//=========================Search cases======================================
	
	@When("I search for {string}")
	public void i_search_for_iphone(String paramSearch) {
		driver.findElement(By.xpath("//input[@id=\"gh-ac\"]")).sendKeys(paramSearch);
		driver.findElement(By.xpath("//input[@id=\"gh-btn\"]")).click();
	}
	
	@Then("I validate at least {int} items are present")
	public void i_validate_at_least_items_are_present(int numOfItems) {
		String itemCount = driver.findElement(By.cssSelector("#mainContent > div.s-answer-region.s-answer-region-center-top > div > div.clearfix.srp-controls__row-2 > div:nth-child(1) > div.srp-controls__control.srp-controls__count > h1 > span:nth-child(1)"))
				.getText()
				.trim()
				.replaceAll(",", "");
		
		if (Integer.parseInt(itemCount) < numOfItems) {
			fail("Less than 1000 results");
		}
		
	}
	
	
	
	@When("I search for {string} in {string} category")
	public void i_search_for_in_category(String product, String category) {
		//Finder
		driver.findElement(By.xpath("//input[@id=\"gh-ac\"]")).sendKeys(product);
		//category
		driver.findElement(
				By.xpath("//select[@id='gh-cat']")
				).click();//abrir el selct es optional
		//Se toma toda la lista del select
		List<WebElement> catalog = driver.findElements(
				By.xpath("//select[@id='gh-cat']/option")
				);
		//Se recorre la lista se compara y se da click
		boolean categoryExists = false;
		for (WebElement option : catalog) {
			if (option.getText().trim().toLowerCase().equals(category.toLowerCase())) {
				option.click();
				categoryExists = true;
				break;
			}
		}
		
		if (!categoryExists) {
			fail("Category doesnt exist");
		}
		//Start searching
		driver.findElement(By.xpath("//input[@id=\"gh-btn\"]")).click();
	}

	
	//====================================Scenario outline=================================
	
	@When("I click on {string}")
	public void i_click_on(String linkName) {
		driver.findElement(By.linkText(linkName)).click();
	}
	
	@Then("I validate that page navigates to {string} and title contains {string}")
	public void i_validate_that_page_navigates_to_and_title_contains(String url, String pageTitle) {
	    //pagetitle
		if (!driver.getTitle().contains(pageTitle)) {
			fail("Pagetitle doesnt match");
		}
		
		//url
		if (!driver.getCurrentUrl().equals(url)) {
			fail("Url doesnt match");
		}
		
	}



	

}
