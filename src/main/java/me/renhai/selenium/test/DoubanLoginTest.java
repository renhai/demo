package me.renhai.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import me.renhai.selenium.BrowserFactory;
import me.renhai.selenium.pages.DoubanLoginPage;

public class DoubanLoginTest {

	public static void main(String[] args) {
		new DoubanLoginTest().testDoubanLogin();
	}

	public void testDoubanLogin() {
		WebDriver driver = BrowserFactory.startBrowser("chrome", "https://www.douban.com/accounts/login");
		DoubanLoginPage homePage = PageFactory.initElements(driver, DoubanLoginPage.class);
		homePage.login("myrenhai@163.com", "67063498hai");
	}
}
