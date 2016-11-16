package me.renhai.selenium.pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoubanMusicPage {

	@FindBy(id = "inp-query")
	private WebElement searchInput;

	@FindBy(xpath = "/html[@class='ua-mac ua-webkit']/body/div[@id='db-nav-music']/div[@class='nav-wrap']/div[@class='nav-primary']/div[@class='nav-search']/form/fieldset/div[@class='inp-btn']/input")
	private WebElement searchBtn;

	@FindBy(className = "nbg")
	private List<WebElement> results;

	@FindBy(xpath = "//a[@class='j a_show_full']")
	private WebElement showMore;

	@FindBy(xpath = "//span[@class='all hidden']")
	private WebElement intro;//点击“展开全部”
	
	@FindBy(xpath = "//div[@id='link-report']/span")
	private WebElement intro2;//没有“展开全部”button
	

	public void doSearch(String singer, String album) {
		searchInput.sendKeys(singer + " " + album);
		searchBtn.click();

		if (results == null || results.size() == 0) {
			System.out.println("没有搜索结果");
			return;
		}

		System.out.println(results.get(0).getAttribute("href"));
		results.get(0).click();

		if (isElementPresent(showMore)) {
			showMore.click();
			if (isElementPresent(intro)) {
				System.out.println(intro.getAttribute("innerText"));
			}
		} else {
			if (isElementPresent(intro2)) {
				System.out.println(intro2.getAttribute("textContent"));
				System.out.println(intro2.getAttribute("innerText"));
				System.out.println(intro2.getAttribute("innerHTML"));
			} 
		}

	}

	public boolean isElementPresent(WebElement element) {
		try {
			element.getText();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
