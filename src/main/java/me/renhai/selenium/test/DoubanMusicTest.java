package me.renhai.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import me.renhai.selenium.BrowserFactory;
import me.renhai.selenium.pages.DoubanMusicHomePage;
import me.renhai.selenium.pages.DoubanMusicPage;

public class DoubanMusicTest {

	public static void main(String[] args) {
//		new DoubanMusicTest().testDoubanMusicSearch();
		new DoubanMusicTest().testDoubanMusicSearch2();
	}

	public void testDoubanMusicSearch() {
		WebDriver driver = BrowserFactory.startBrowser("chrome");
		driver.get("https://music.douban.com/");
		DoubanMusicPage musicPage = PageFactory.initElements(driver, DoubanMusicPage.class);
		musicPage.doSearch("崔健", "光冻");
	}
	
	public void testDoubanMusicSearch2() {
		WebDriver driver = BrowserFactory.startBrowser("");
		DoubanMusicHomePage musicPage = new DoubanMusicHomePage(driver);
		musicPage.doSearch("王梵瑞", "时光谣");
		musicPage.doSearch("李健", "似水流年");
		musicPage.doSearch("王凡瑞", "青春");
		musicPage.doSearch("许巍", "那一年");
		musicPage.doSearch("崔健", "光冻");
		musicPage.doSearch("高晓松", "青春无悔");
		musicPage.doSearch("Bob Dylan", "Street Legal");
	}
	
}
