package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.utils.CommonActions;
import static com.automation.utils.DriverUtils.getDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(id = "searchInput")
	WebElement searchInputID;

	@FindBy(id = "searchButton")
	WebElement searchButtonID;

	@FindBy(css = ".searchdidyoumean")
	WebElement searchdidyoumean;

	@FindBy(id = "mw-search-DYM-suggestion")
	WebElement suggestion;

	@FindBy(className = "results-info")
	WebElement resultInfo;

	@FindBy(className = "mw-search-result")
	WebElement mwsearchresult;

	@FindBy(className = "searchmatch")
	WebElement searchmatch;

	@FindBy(className = "firstHeading")
	WebElement firstHeading;
	
	
	
	
	public void searchWikipedia(String searchInput) {

		CommonActions.sendKeysTo(searchInputID, searchInput);
		CommonActions.clickOnElement(searchButtonID);

	}

	public String getDidYouMeanString() {

		return CommonActions.getText(searchdidyoumean);
	}

	public int getresultCount() {

		String count = CommonActions.getText(resultInfo);

		Pattern p = Pattern.compile("[\\d]+[^\\d]+([\\d]+)");
		Matcher m = p.matcher(count);
		while (m.find()) {
			return Integer.valueOf(m.group(1));
		}
		return 0;
	}

	public void rectifySearch() {

		CommonActions.clickOnElement(suggestion);

	}

	public String selectFirstEntry() {

		String firstPage = CommonActions.getText(mwsearchresult);
		CommonActions.clickOnElement(searchmatch);
		return firstPage;
	}

	public String getArticlePageDetails() {
		
		return CommonActions.getText(firstHeading);
				
		
	}

}
