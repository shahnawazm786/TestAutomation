package com.steps;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.SeleniumCommonFunction;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdef {
	WebDriver driver=Hooks.driver;
	@Given("user enter the url")
	public void user_enter_the_url() {
		driver.get("https://demoqa.com/frames");
	}

	@When("finnd out the frame")
	public void finnd_out_the_frame() {
		//driver.switchTo().frame(4);
		//iframe[@id='frame1']
		//driver.switchTo().frame("frame1");
		new WebDriverWait(driver, Duration.ofSeconds(20)).
		ignoring(NoSuchElementException.class)
		.until(dr->dr.findElement(By.xpath("//iframe[@id='frame1']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));


	}

	@Then("validate the element of frame")
	public void validate_the_element_of_frame() {
		String actual=driver.findElement(By.id("sampleHeading")).getText();
		//assertEqual("",actual);
		assertEquals("Passed","This is a sample page", actual);
	}

	/*
	 *  ******************************* Student Form
	 */
	@Given("user enter the url for practice form")
	public void user_enter_the_url_for_practice_form() {
		System.out.println("enter the form");
	}
	@And("verify the textbox visibility")
	public void erify_the_textbox_visibility() {

	}
	@When("enter the data into first name")
	public void enter_data_into_first_time() {

	}
	@And("enter the data into mobile text box")
	public void enter_the_data_into_mobile_text_box() {

	}
	@Then("enter the subject")
	public void enter_the_subject() {

	}

	
	/*
	 *          Shadow Element into the Frame
	 */

	@Given("user navigate the url")
	public void user_navigate_the_url() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
	}
	@And("user switch to iframe")
	public void user_switch_to_iframe() {
		WebElement frame=driver.findElement(By.id("pact"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		String js="arguments[0].scrollIntoView(true)";
		jse.executeScript(js,frame);
		driver.switchTo().frame("pact");
	}

	@When("user add data into in input box")
	public void user_add_data_into_in_input_box() {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		WebElement element=(WebElement)jse.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		
		String js="arguments[0].setAttribute('value','Kebab')";
		jse.executeScript(js, element);
	}
	@Then("verify data is added")
	public void verify_data_is_added() {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		WebElement element=(WebElement)jse.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
		
		String js="return arguments[0].value";
		String val=(String)jse.executeScript(js, element);
		System.out.println(val);
		assertEquals("Kebab",val);
	}
	//table[id='resultTable']>tbody>tr:nth-child(1)>td:nth-child(1)
	@And("select the first row of table")
	public void select_the_first_row_of_table() throws Throwable{
		driver.switchTo().defaultContent();
		//WebElement element=driver.findElement(By.cssSelector("table[id='resultTable']>tbody>tr:nth-child(1)>td:nth-child(1)>input"));
		//SeleniumCommonFunction.waitForElementClikable(driver, By.cssSelector("table[id='resultTable']>tbody>tr:nth-child(1)>td:nth-child(1)>input")).click();;
	//	driver.findElement(By.cssSelector("table[id='resultTable']>tbody>tr:nth-child(1)>td:nth-child(1)>input")).click();
		
	}
	
}
