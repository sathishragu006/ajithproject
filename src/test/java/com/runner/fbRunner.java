package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.baseclass.BaseClass;
import com.propertyfile.ConfigrationHelper;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\feature\\fbproject.feature", glue = "com.stepDefinition")
//plugin="pretty","html:Report/HtmlReport.html"
public class fbRunner {
	public static WebDriver driver;

	@BeforeClass
	public static void setUp() throws IOException {
		String browser = ConfigrationHelper.getInstance().getBrowser();
		BaseClass.browserLaunch(browser);
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterClass
	public static void tearDown() {
		driver.close();

	}

}
