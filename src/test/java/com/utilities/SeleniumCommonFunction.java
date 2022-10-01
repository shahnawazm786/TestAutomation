package com.utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCommonFunction {

	public static void clickElement(WebDriver driver,By locator) {
		new WebDriverWait(driver,Duration.ofSeconds(20))
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.ignoring(ElementNotInteractableException.class)
		.ignoring(IllegalStateException.class)
		.until(dr->dr.findElement(locator));

	}

	public static void clickElement(WebDriver driver,By locator,long timeInSecond) {
		new WebDriverWait(driver,Duration.ofSeconds(timeInSecond))
		.pollingEvery(Duration.ofMillis(500))
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.ignoring(ElementNotInteractableException.class)
		.ignoring(IllegalStateException.class)
		.until(dr->dr.findElement(locator));

	}
	public static void waitForElementClikable(WebDriver driver,By locator) {
		List listofException=new ArrayList();
		
		new WebDriverWait(driver,Duration.ofSeconds(20))
		.ignoringAll(TimeoutException.class,NoSuchElementException.class,StaleElementReferenceException.class,ElementClickInterceptedException.class)
		
		
		}

}
