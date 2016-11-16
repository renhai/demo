package me.renhai.selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DoubanMusicHomePage {
	
	private static final String DOUBAN_MUSIC_URL = "https://music.douban.com/";
	
	private WebDriver driver;
	
	public DoubanMusicHomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By searchInput = By.id("inp-query");
	private By searchBtn = By.xpath("/html[@class='ua-mac ua-webkit']/body/div[@id='db-nav-music']/div[@class='nav-wrap']/div[@class='nav-primary']/div[@class='nav-search']/form/fieldset/div[@class='inp-btn']/input");
	private By searchResults = By.className("nbg");
	private By showMore = By.xpath("//a[@class='j a_show_full']");
	private By intro = By.xpath("//span[@class='all hidden']");//点击“展开全部”
	private By intro2 = By.xpath("//div[@id='link-report']/span");//没有“展开全部”button
	

	public void doSearch(String singer, String album) {
		System.out.println(singer + " " + "<<" + album + ">>");
		driver.get(DOUBAN_MUSIC_URL);
		driver.findElement(searchInput).sendKeys(singer + " " + album);
		driver.findElement(searchBtn).click();
		List<WebElement> results = driver.findElements(searchResults);
		if (results == null || results.size() == 0) {
			System.out.println("没有搜索结果");
			return;
		}

		System.out.println(results.get(0).getAttribute("href"));
		results.get(0).click();

		List<WebElement> showMoreList = driver.findElements(showMore);
		if (showMoreList.size() > 0) {
			showMoreList.get(0).click();
			List<WebElement> introList = driver.findElements(intro);
			if (introList.size() > 0) {
				System.out.println(introList.get(0).getAttribute("innerText"));
			}
		} else {
			List<WebElement> introList = driver.findElements(intro2);
			if (introList.size() > 0) {
				System.out.println(introList.get(0).getAttribute("innerText"));
//				System.out.println(introList.get(0).getAttribute("textContent"));
//				System.out.println(introList.get(0).getAttribute("innerHTML"));
			}
		}
	}

}
