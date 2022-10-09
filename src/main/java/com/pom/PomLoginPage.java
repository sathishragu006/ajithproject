
package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomLoginPage {
	public static WebDriver driver;

	public PomLoginPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement gettext1() {
		return text1;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	@FindBy(tagName = "h2")
	private WebElement text1;
	

	@FindBy(xpath = "//input[@type='text']")
	private WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@name='login']")
	private WebElement login;

}
