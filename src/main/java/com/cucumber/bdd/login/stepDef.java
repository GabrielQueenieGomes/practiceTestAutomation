package com.cucumber.bdd.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDef {
WebDriver driver;
	
	@Given("open chrome")
	public void open_chrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("go to app link")
	public void go_to_app_link() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	@When("enter valid username")
	public void enter_valid_username() {
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("student");
	}

	@When("enter valid password")
	public void enter_valid_password() {
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Password123");
	}

	@When("click login button")
	public void click_login_button() {
		driver.findElement(By.xpath("//*[@id='submit']")).click();
	}

	@Then("login should pass and there should be logout button visible")
	public void login_should_pass_and_there_should_be_logout_button_visible() {
		Boolean status = driver.findElement(By.xpath("//*[@class='wp-block-button__link has-text-color has-background has-very-dark-gray-background-color']")).isDisplayed();
		System.out.println("Log out button there or not = " + status);

	driver.quit();
	}

	@When("enter invalid username")
	public void enter_invalid_username() {
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("incorrectUser");
	}

	@When("enter invalid password")
	public void enter_invalid_password() {
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("incorrectPassword");
	}

	@Then("login fails and no logout button")
	public void login_fails_and_no_logout_button() {
		try {
			Boolean status = driver.findElement(By.xpath("//*[@class='wp-block-button__link has-text-color has-background has-very-dark-gray-background-color']")).isDisplayed();
			System.out.println("Log out button there or not = " + status);
		} catch (Exception e) {
			
		}
	    driver.quit();
	}

}
