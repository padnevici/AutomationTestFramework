package com.trifinlabs.web;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Browser {
	private static WebDriver webDriver = null;
    private static Logger logger = LoggerFactory.getLogger(Browser.class);

	public static void initialize() {
		logger.debug(String.format("Initialising"));
		String browserType = Configs.getApplication().getProperty("browser");
		if (browserType.equals("chrome"))
			initChrome();
		else if (browserType.equals("firefox"))
			initFirefox();
		else
			initFirefox();
	}

	private static void initChrome() {
		logger.debug(String.format("Starting Chrome browser"));
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		webDriver = new ChromeDriver();
		init();
	}

	private static void initFirefox() {
		logger.debug(String.format("Starting Firefox browser"));
		webDriver = new FirefoxDriver();
		init();
	}

	private static void init() {
		navigate(Configs.getApplication().getProperty("defaul-url"));
		webDriver.manage().window().setPosition(new Point(0, 0));
		webDriver.manage().window().maximize();
//		webDriver
//				.manage()
//				.timeouts()
//				.implicitlyWait(
//						Configs.getInstance().getImplicitSeleniumWaitTime(),
//						TimeUnit.SECONDS);
	}

	public static void navigate(String url) {
		logger.info(String.format("Navigating to [%s] url", url));
		webDriver.navigate().to(url);
//		implicitWait();
	}

	public static void quit() {
		logger.debug(String.format("Quiting the browser"));
		webDriver.quit();
	}

//	public static void implicitWait() {
//		implicitWait(Configs.getInstance().getImplicitWaitTime());
//	}

	public static void implicitWait(long milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.error("An error during implicit waiting", e);
		}
	}

	public static String getTitle() {
		return webDriver.getTitle().trim().toLowerCase();
	}

	public static WebDriver getWebDriver() {
		return webDriver;
	}

	public static void clickOnWebElement(WebElement element) {
		element.click();
//		implicitWait();
	}

	public static boolean checkIfElementExists(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static void executeJavaScript(String jsCode) {
		JavascriptExecutor jsx = (JavascriptExecutor) webDriver;
		jsx.executeScript(jsCode, "");
	}
}
