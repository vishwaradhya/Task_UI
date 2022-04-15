package com.automation.utils;

import org.openqa.selenium.WebElement;

import static com.automation.utils.WaitUtils.waitForVisible;

public class CommonActions extends DriverUtils {
	
	public static void clickOnElement(WebElement element) {
		waitForVisible(element);
		element.click();
	}

	public static void sendKeysTo(WebElement element, String text) {
		waitForVisible(element);
		element.clear();
		element.sendKeys(text);
	}

	
	public static void navigateToUrl(String url) {
		
		driver.get(url);
	}

	public static String getText(WebElement element) {
		waitForVisible(element);
		return element.getText();
	}

}
