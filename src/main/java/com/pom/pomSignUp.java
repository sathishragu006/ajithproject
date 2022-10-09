package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pomSignUp {
	public static WebDriver driver;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement name;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement mobile;

	@FindBy(xpath = "//select[@name='birthday_day']")
	private WebElement birthday;

	@FindBy(xpath = "//select[@name='birthday_month']")
	private WebElement birthdaymonth;

	@FindBy(xpath = "//select[@name='birthday_year']")
	private WebElement birthdayyear;

	@FindBy(xpath = "(//input[@type='radio'])[2]")
	private WebElement gender;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement signin;

	public pomSignUp(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getBirthday() {
		return birthday;
	}

	public WebElement getBirthdaymonth() {
		return birthdaymonth;
	}

	public WebElement getBirthdayyear() {
		return birthdayyear;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getSignin() {
		return signin;
	}

}
