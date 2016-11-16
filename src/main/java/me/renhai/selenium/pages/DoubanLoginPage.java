package me.renhai.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoubanLoginPage {
	
//	private WebDriver webdriver;	
//	
//	public void setWebdriver(WebDriver webdriver) {
//		this.webdriver = webdriver;
//	}

	@FindBy(id = "email")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(xpath = ".//input[@class='btn-submit']")
					 
	private WebElement submitButton;
	
	public void login(String uid, String pass) {
		username.sendKeys(uid);
		password.sendKeys(pass);
		
		//waiting for input CAPTCHA
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		submitButton.click();
	}
}
