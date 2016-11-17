package me.renhai.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.renhai.selenium.BrowserFactory;
import me.renhai.selenium.pages.DoubanMusicHomePage;
import me.renhai.selenium.pages.DoubanMusicPage;

public class DoubanMusicTest {
	private static final Logger LOG = LoggerFactory.getLogger(DoubanMusicTest.class);

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
//		LOG.info(musicPage.doSearch("李健", "似水流年").toString());
//		LOG.info(musicPage.doSearch("王凡瑞", "青春").toString());
//		LOG.info(musicPage.doSearch("许巍", "那一年").toString());
//		LOG.info(musicPage.doSearch("崔健", "光冻").toString());
//		LOG.info(musicPage.doSearch("高晓松", "青春无悔").toString());
//		LOG.info(musicPage.doSearch("Bob Dylan", "Street Legal").toString());
//		LOG.info(musicPage.doSearch("Norah Jones", "Come Away With Me").toString());
//		LOG.info(musicPage.doSearch("Norah Jones", "Norah Jones And The Handsome Band").toString());
//		LOG.info(musicPage.doSearch("", "Hard Rain - The Songs of Bob Dylan & Leonard Cohen").toString());
//		LOG.info(musicPage.doSearch("李健", "").toString());
//		LOG.info(musicPage.doSearch("东方快车", "飞碟1991这一年1").toString());
//		LOG.info(musicPage.doSearch("东方快车", "摇滚寓言").toString());
		LOG.info(musicPage.doSearch("东方快车", "2006红红青春").toString());
		
	}
	
}
