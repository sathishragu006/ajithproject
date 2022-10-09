package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SingleTonDesignPatten {

	public static WebDriver driver;

	public SingleTonDesignPatten(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public PomLoginPage getlogIn() {
		PomLoginPage log = new PomLoginPage(driver);
		return log;
	}

	public pomSignUp getsignUp() {
		pomSignUp signup = new pomSignUp(driver);
		return signup;
	}
}
