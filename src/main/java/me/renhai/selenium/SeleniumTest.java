package me.renhai.selenium;

import javax.naming.directory.DirContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumTest {

	public static void main(String[] args) {
		
//		for (int i = 0; i < 3000; i++) {
//			vote();
//		}
		
//		System.setProperty("browser", "chrome");
//		open("http://www.baidu.com");
//		System.out.println(title());
		
//		  $(By.name("user.name")).setValue("johny");
//		  $("#submit").click();
//		  $(".loading_progress").should(disappear); // Waits until element disappears
//		  $("#username").shouldHave(text("Hello, Johny!")); // Waits until element gets text
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/local/bin/phantomjs");
		PhantomJSDriver driver = new PhantomJSDriver(capabilities);
		driver.get("http://baike.baidu.com/view/15290368.htm");
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		System.out.println("*****");
		Object request = driver.executePhantomJS("this.onResourceRequested = function(request, net) {" +
		        "   console.log('REQUEST ' + request.url);" +
		        "   if (request.url.indexOf('google-analytics') !== -1) {" +
		        "       console.log('Abort ' + request.url);" +
		        "       net.abort();" +
		        "   }" +
		        "};");
		System.out.println(request);
		driver.quit();
	}
	
	private static void vote() {
		WebDriver driver = new ChromeDriver();

		try {

			//Weike%5FUseradopt%5F173321%5F3
			
			// And now use this to visit Google
			driver.get("http://weike.enetedu.com/play.asp?vodid=173321&e=3");
			
//			for (Cookie co : driver.manage().getCookies()) {
//				System.out.println(co);
//			}
			driver.manage().deleteAllCookies();
			

			WebElement element = driver.findElement(By.cssSelector("span[class='bigredtitle']"));
			System.out.println(element);
			element.click();

			/*
			// Find the text input element by its name
			WebElement element = driver.findElement(By.name("q"));

			// Enter something to search for
			element.sendKeys("Cheese!");

			// Now submit the form. WebDriver will find the form for us from the element
			element.submit();
			*/

			// Check the title of the page
			System.out.println("Page title is: " + driver.getTitle());
			System.out.println("投票成功");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
