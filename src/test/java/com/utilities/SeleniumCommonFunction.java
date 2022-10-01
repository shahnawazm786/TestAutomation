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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCommonFunction {

	static WebDriverWait wait;
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
	public static WebElement waitForElementClikable(WebDriver driver,By locator) {
		List listofException=new ArrayList<>();
		listofException.add(NoSuchElementException.class);
		listofException.add(StaleElementReferenceException.class);
		listofException.add(ElementClickInterceptedException.class);
		listofException.add(TimeoutException.class);
		WebElement ele=(WebElement)new WebDriverWait(driver,Duration.ofSeconds(20))
		.ignoreAll(listofException)
		.until(ExpectedConditions.elementToBeClickable(locator));
		return ele;
		}
	
	public static WebElement waitForElementClickable(WebDriver driver,WebElement element) throws Throwable {
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitForElementClickable(WebDriver driver,By locator) throws Throwable{
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.withTimeout(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void click(WebDriver driver,By locator) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(locator).click();
	}
}
