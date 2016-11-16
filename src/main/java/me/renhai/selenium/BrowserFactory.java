package me.renhai.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
	
	private static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url) {
		if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/andy/Documents/workspace/chromedriver");
			driver = new ChromeDriver();
//			try {
//				driver = new RemoteWebDriver(new URL("http://localhost:8090"), DesiredCapabilities.chrome());
//			} catch (MalformedURLException e) {
//				e.printStackTrace();
//			}
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		} else {
			return null;
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}
