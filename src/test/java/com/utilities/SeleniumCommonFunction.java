package com.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCommonFunction {
	
	public static void clickElement(WebDriver driver,By locator) {
		new WebDriverWait(driver,Duration.ofSeconds(20))
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.ignoring(ElementNotInteractableException.class)
		.until(dr->dr.findElement(locator));
		
	}

}
