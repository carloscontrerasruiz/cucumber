package steps;

import static org.junit.Assert.fail;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectModel.actions.CommonActions;
import pageObjectModel.actions.EbayAdvancedEscenario_Actions;

public class EbayAdvancedEscenario_Steps {
	
	CommonActions commonActions;
	EbayAdvancedEscenario_Actions advancedActions;

	public EbayAdvancedEscenario_Steps(CommonActions commonActions, EbayAdvancedEscenario_Actions actions) {
		this.commonActions = commonActions;
		advancedActions = actions;
	}

	@Given("I am Advanced search page")
	public void i_am_advanced_search_page() {
		commonActions.goToUrl("https://www.ebay.com/globaldeals/");
	}

	@When("I click on Ebay Logo")
	public void i_click_on_ebay_logo() {
		advancedActions.clickEbayLogo();
	}

	@Then("I am navigated to Ebay Home Page")
	public void i_am_navigated_to_ebay_home_page() {
		String expectedUrl = "https://www.ebay.com/";
		if (!expectedUrl.equals(commonActions.getCurrentUrl())) {
			fail("Page does not navigate to home page");
		}
	}
	
	
	@Given("Iam Ebay Advanced Search page")
	public void iam_ebay_advanced_search_page() {
		commonActions.goToUrl("https://www.ebay.com/sch/ebayadvsearch");
	}
	
	@When("I advance search an item")
	public void i_advance_search_an_item(DataTable dataTable) {
		
		advancedActions.searchString(dataTable.cell(1, 0));
		advancedActions.excludeString(dataTable.cell(1, 1));
		advancedActions.minPrice(dataTable.cell(1, 2));
		advancedActions.maxPrice(dataTable.cell(1, 3));
		
		advancedActions.clickAdvancedSearchBtn();
	   
	}



}
