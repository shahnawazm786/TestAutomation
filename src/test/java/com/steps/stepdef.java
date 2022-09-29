package com.steps;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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



}
