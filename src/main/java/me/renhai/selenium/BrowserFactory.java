package me.renhai.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
	
	private static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName) {
		if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/andy/Documents/workspace/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		} else {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true); // enabled by default
			caps.setCapability(
			    PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
			    "/Users/andy/Documents/workspace/phantomjs-2.1.1-macosx/bin/phantomjs"
			);
//			System.setProperty("phantomjs.binary.path", "/Users/andy/Documents/workspace/phantomjs-2.1.1-macosx/bin/phantomjs");
			driver = new PhantomJSDriver(caps);
			
//			driver = new HtmlUnitDriver();
		}
		
		driver.manage().window().maximize();
//		driver.get(url);
		return driver;
	}
}
