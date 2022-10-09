package com.fbProject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.baseclass.BaseClass;
import com.pom.PomLoginPage;
import com.pom.SingleTonDesignPatten;
import com.pom.pomSignUp;
import com.propertyfile.ConfigrationHelper;

public class fbUserLogin extends BaseClass {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, Exception {
        String browser = ConfigrationHelper.getInstance().getBrowser();
		driver = browserLaunch(browser);
		
		SingleTonDesignPatten st = new SingleTonDesignPatten(driver);
		String url = ConfigrationHelper.getInstance().getUrl();
		launchUrlBaseClass(url);

		WebElement gettext1 = st.getlogIn().gettext1();
		System.out.println(gettext1.getText());

		// driver.getTitle();

		// WebElement username = driver.findElement(By.xpath("//input[@type='text']"));

		String username = ConfigrationHelper.getInstance().getUsername();
		userInput(st.getlogIn().getUsername(), username);

		// userInput(st.getlogIn().getUsername(), "java@gmail.com");

		// driver.findElement(By.xpath("//input[@type='password']"));
		String password = ConfigrationHelper.getInstance().getPassword();
		userInput(st.getlogIn().getPassword(), password);
		// userInput(st.getlogIn().getPassword(), "abc@123");

		// WebElement login = driver.findElement(By.xpath("//button[@name='login']"));

		clickOnElement(st.getlogIn().getLogin());

		threadsleepBaseClass();

		launchUrlBaseClass("https://www.facebook.com/r.php?locale=en_GB&display=page");

		WebElement name = driver.findElement(By.xpath("//input[@name='firstname']"));
		userInput(name, "sathish");
		// ==========
		// WebElement surename =
		// driver.findElement(By.xpath("//input[@name='lastname']"));
		userInput(st.getsignUp().getName(), "ragu");

		// driver.findElement(By.xpath("//input[@type='password']"));
		userInput(st.getsignUp().getMobile(), "9789583859");

		// WebElement birthday =
		// driver.findElement(By.xpath("//select[@name='birthday_day']"));
		selectMethods(st.getsignUp().getBirthday(), "value", "5");

		// WebElement birthdaymonth =
		// driver.findElement(By.xpath("//select[@name='birthday_month']"));
		selectMethods(st.getsignUp().getBirthdaymonth(), "Index", "5");

		// WebElement birthdayyear =
		// driver.findElement(By.xpath("//select[@name='birthday_year']"));
		selectMethods(st.getsignUp().getBirthdayyear(), "text", "1995");

		// WebElement gender =
		// driver.findElement(By.xpath("(//input[@type='radio'])[2]"));

		clickOnElement(st.getsignUp().getGender());

//	   WebElement signin = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));

		clickOnElement(st.getsignUp().getSignin());

		screenShootFileUtiles("sathish");

	}
}