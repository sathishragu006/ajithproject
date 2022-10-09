package com.baseclass;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	// ============WebElement Methods=============
	public static WebDriver driver;

	public static void userInput(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void printText(WebElement element) {
		String text = element.getText();

	}

	public static void clear(WebElement element) {
		element.clear();
	}

	public static void printGetAttribute(WebElement element, String entryset) {
		String attribute = element.getAttribute(entryset);
		System.out.println(attribute);
	}

	public static void booleanIsSelected(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println("The Check whether element is selected:" + selected);
	}

	public static void booleanIsEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println("The Check whether element is enabled:" + enabled);
	}

	public static void booleanIsDisplay(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println("The Check whether element is diplayed:" + displayed);
	}

	// =================Webdriver Methods==================
	public static WebDriver browserLaunch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Sathish\\eclipse-workspace\\demo\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {// microsoft
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("gecko")) {// firefox
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser");

		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void launchUrlBaseClass(String Url) {
		driver.get(Url);
	}

	public static void closeBaseClass() {
		driver.close();
	}

	public static void quiteBaseClass() {
		driver.quit();
	}

	public static void threadsleepBaseClass() throws Exception {
		Thread.sleep(3000);
	}

	public static void implicitWaitBaseClass() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void exclicityWaitBaseClass() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(null));// =============

	}

	public static void navagationForwardBaseClass() {
		driver.navigate().forward();
	}

	public static void navagationBackwardBaseClass() {
		driver.navigate().back();
	}

	public static void navagationRefereshBaseClass() {
		driver.navigate().refresh();
	}

	public static void getTextBaseClass() {
		String printtitle = driver.getTitle();
		System.out.println(printtitle);
	}

	public static void getCurrentUrlBaseClass() {
		String printcurrentUrl = driver.getCurrentUrl();
		System.out.println(printcurrentUrl);

	}

	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);// click
	}

	public static void jsSendkeys(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;// scroll element
		js.executeScript("arguments[0].value=' " + value + "'; ", element);
	}

	public static void jsScrollBy(int V, int H) {
		JavascriptExecutor js = (JavascriptExecutor) driver;// scroll
		js.executeScript("window.scrollBy(" + V + "," + H + ")");
	}

	public static void jsScrollElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;// scroll element
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void screenShootFileHandler(String picname) throws Exception {// screenShootFileHandler
		TakesScreenshot screen = (TakesScreenshot) driver;
		File a = screen.getScreenshotAs(OutputType.FILE);
		File b = new File("C:\\Users\\Sathish\\eclipse-workspace\\Siva\\ScreenShot\\" + picname + "png");
		FileHandler.copy(a, b);
	}

	public static void screenShootFileUtiles(String value) throws Exception {
		TakesScreenshot screen = (TakesScreenshot) driver;// screenShootFileUtiles
		File a = screen.getScreenshotAs(OutputType.FILE);
		File b = new File("C:\\Users\\Sathish\\eclipse-workspace\\Siva\\ScreenShot\\" + value + ".png");
		FileUtils.copyFile(a, b);
	}

	public static void mouseActionBaseClass(String options, WebElement element) {// =========???????
		Actions a = new Actions(driver);
		if (options.equalsIgnoreCase("m2e")) {
			a.moveToElement(element).perform();
		} else if (options.equalsIgnoreCase("rc")) {
			a.contextClick(element).perform();
		} else if (options.equalsIgnoreCase("lc")) {
			a.click(element).perform();
		} else if (options.equalsIgnoreCase("dc")) {
			a.doubleClick(element).perform();
		} else if (options.equalsIgnoreCase("CAH")) {
			a.clickAndHold(element).perform();
		} else if (options.equalsIgnoreCase("R")) {
			a.release(element).perform();
		} else {
			System.out.println("Wrong Action");
		}

	}

	public static void selectMethods(WebElement element, String options, String value) {
		Select s = new Select(element);
		if (options.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (options.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);

		} else if (options.equalsIgnoreCase("Index")) {
			int n = Integer.parseInt(value);
			s.selectByIndex(n);

		} else {
			System.out.println("Invalid Select");
		}
	}

	public static void deselectMethods(WebElement element, String options, String value) {
		Select s = new Select(element);
		if (options.equalsIgnoreCase("value")) {
			s.deselectByValue(value);
		} else if (options.equalsIgnoreCase("text")) {
			s.deselectByVisibleText(value);

		} else if (options.equalsIgnoreCase("Index")) {
			int n = Integer.parseInt(value);
			s.deselectByIndex(n);
		} else {
			System.out.println("Invalid Select");
		}
	}

	public static void selectIsMultiple(WebElement element) {
		Select s = new Select(element);
		boolean m = s.isMultiple();
		System.out.println("Is Multiple" + m);

	}

	public static void selectDeSelectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	public static void selectFirstSelected(WebElement element) {
		Select s = new Select(element);
		WebElement first = s.getFirstSelectedOption();
		System.out.println("First Selected option is:" + first);
	}

	public static void selectgetOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement oneoption : options) {
			System.out.println("The Options In Dropdown Is:" + oneoption);
		}
	}

	public static void selectgetallOptions(WebElement element, String value) {
		Select s = new Select(element);
		List<WebElement> allselected = s.getAllSelectedOptions();
		for (WebElement select : allselected) {
			System.out.println("The selected Options Is:" + select);
		}
	}

	public static void alertAccept(String alert) {
		Alert a = driver.switchTo().alert();
		if (alert.equalsIgnoreCase("ok")) {
			a.accept();
		} else if (alert.equalsIgnoreCase("cancel")) {
			a.dismiss();
		}
	}

	public static void frames(String value) {
		if (value.equalsIgnoreCase("index")) {
			int f = Integer.parseInt(value);
			driver.switchTo().frame(f);
		} else if (value.equalsIgnoreCase("name")) {
			driver.switchTo().frame(value);
		} else if (value.equalsIgnoreCase("PF")) {
			driver.switchTo().parentFrame();
		} else if (value.equalsIgnoreCase("DC")) {
			driver.switchTo().defaultContent();
		} else if (value.equalsIgnoreCase("name")) {
			driver.switchTo().frame(value);
		} else {
			System.out.println("Wrong Frame");
		}
	}

	public static void frameElements(WebElement frameElements) {
		driver.switchTo().frame(frameElements);
	}

//=================================================
	public static void jsBaseClassSendKeysSetAttribute() {
		JavascriptExecutor js = (JavascriptExecutor) driver;// sendkeys setAttribute
		js.executeScript("document.getElementById('Email').setAttribute('value','abcd123@gmail.com')");
	}

	public static void jsBaseClassSendKeysValue() {
		JavascriptExecutor js = (JavascriptExecutor) driver;// sendkeys value
		js.executeScript("document.getElementById('Email').value='softwaretesting.com';");
	}

public static void jsBaseClassToCheckBox() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('terms_checkbox').checked=true");// to check checkbox

}}

//public static void jsBaseClassMultipleArguments() {
//	JavascriptExecutor js = (JavascriptExecutor) driver;// to check multiple arguments
//	js.executeScript("arguments[0].setAttribute('style',arguments[1])", file, "0");

//}