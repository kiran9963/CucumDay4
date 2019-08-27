package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Day4Task {
	static WebDriver driver;
	@Given("User should  launch the browser")
	public void user_should_launch_the_browser() {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-kk\\Projectautomated\\driver\\chromedriver.exe");
	   driver =new ChromeDriver();
	   driver.get("http://www.demo.guru99.com/telecom/");
	   
	}

	@Given("User click the add customer button")
	public void user_click_the_add_customer_button() {
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	}

	@When("User provide valid details of customer")
	public void user_provide_valid_details_of_customer(io.cucumber.datatable.DataTable data) {
		System.out.println("when-1");
		List<String> oned = data.asList(String.class);
		driver.findElement(By.xpath("//label[text()='Done']")).click();
		driver.findElement(By.id("fname")).sendKeys(oned.get(0));
		driver.findElement(By.id("lname")).sendKeys(oned.get(1));
		driver.findElement(By.id("email")).sendKeys(oned.get(2));
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(oned.get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(oned.get(4));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	   
	}

	@Then("verify the customer id is displayed")
	public void verify_the_customer_id_is_displayed() {
	  Assert.assertTrue((driver.findElement(By.xpath("//td[@align='center']")).isDisplayed()));
	}



}
