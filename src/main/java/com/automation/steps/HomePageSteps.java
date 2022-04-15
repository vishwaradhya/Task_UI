package com.automation.steps;

import static com.automation.utils.ConfigUtils.getPropertyByKey;
import static org.junit.Assert.assertTrue;

import com.automation.pages.HomePage;
import com.automation.utils.CommonActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps {
	HomePage homepage = new HomePage();

	public static String firstPageInfo;

	@Given("^A visitor is on the wikipedia home page$")
	public void launchWikiPage() {
		
		CommonActions.navigateToUrl(getPropertyByKey("application.url"));

	}

	@When("^The visitor searches for \"([^\"]*)\"$")
	public void search(String searchInput) {

		homepage.searchWikipedia(searchInput);
	}

	@Then("^A \"([^\"]*)\" suggestion is displayed$")
	public void verifySuggestion(String suggestion) {

		String actual = homepage.getDidYouMeanString();

		assertTrue("Seems like " + actual + " is shown and instead of " + suggestion, actual.contains(suggestion));
	}

	@Then("^The visitor can see (\\d+) results$")
	public void searchResults(int results) {

		int actual = homepage.getresultCount();
		assertTrue("Seems like count not matched expected is " + results + " but actual is " + actual,
				actual == results);

	}

	@When("^select the first entry$")
	public void selectFirstEntry() {
		firstPageInfo = homepage.selectFirstEntry();
	}

	@Then("^The visitor is on the article page of the first hit$")
	public void articlePage() {

		String actual = homepage.getArticlePageDetails();
		assertTrue("Seems like landing page is not correct , expected " + firstPageInfo + " but got " + actual,
				firstPageInfo.contains(actual));

	}

	@Given("^A visitor is on the search result page for \"([^\"]*)\"$")
	public void searchResults(String searchResults) {

	}

	@When("^The visitor uses the \"([^\"]*)\" feature to correct his search$")
	public void recitfySearch(String search) {

		homepage.rectifySearch();

	}
}
