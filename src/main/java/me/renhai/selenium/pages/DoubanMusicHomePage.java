package me.renhai.selenium.pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DoubanMusicHomePage {
	
	private static final Logger LOG = LoggerFactory.getLogger(DoubanMusicHomePage.class);
	
	private static final String DOUBAN_MUSIC_URL = "https://music.douban.com/";
	
	private WebDriver driver;
	
	public DoubanMusicHomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By searchInput = By.id("inp-query");
	private By searchBtn = By.xpath("//div[@class='inp-btn']/input");
	private By searchResults = By.xpath("//a[@class='nbg' and contains(@href,'subject')]");
	private By showMore = By.xpath("//a[@class='j a_show_full']");
	private By intro = By.xpath("//span[@class='all hidden']");//点击“展开全部”
	private By intro2 = By.xpath("//div[@id='link-report']/span");//没有“展开全部”button
	private By tracks = By.xpath("//h2[contains(text(),'曲目')]/following-sibling::div/div");
	private By tracks2 = By.xpath("//h2[contains(text(),'曲目')]/following-sibling::div/ul/li/div/div/div[contains(@class, 'col song-name-short')]/span");
//	private By tracks = By.xpath("//h2[contains(text(),'曲目')]/..");
	
	private By cover = By.xpath("//span[@class='ckd-collect']/a");
	private By name = By.xpath("//div[@id='wrapper']/h1/span");
	private By attrInfo = By.id("info");
	
	public AlbumInfo doSearch(String singer, String album) {
		LOG.info("keyword: " + StringUtils.trimToEmpty(singer + " " + album));
		driver.get(DOUBAN_MUSIC_URL);
		driver.findElement(searchInput).sendKeys(singer + " " + album);
		driver.findElement(searchBtn).click();
		
		WebElement result = filterSearchResults(singer, album);
		if (result == null) {
			LOG.warn("没有搜索结果");
			return null;
		}
		AlbumInfo albumObj = new AlbumInfo();
			
		LOG.info(result.getAttribute("title") + " " + result.getAttribute("href"));
		result.click();
		
		if (isElementPresent(cover)) {
			albumObj.setCover(driver.findElement(cover).getAttribute("href"));
		}
		if (isElementPresent(name)) {
			albumObj.setName(driver.findElement(name).getAttribute("innerText"));
		}
		albumObj.setAttrs(driver.findElement(attrInfo).getAttribute("innerText"));
		albumObj.setIntro(processIntro());;
		albumObj.setTracks(processTracks());
		return albumObj;
	}
	
	private String processTracks() {
		StringBuilder sb = new StringBuilder();
		List<WebElement> trackList = driver.findElements(tracks2);
		if (trackList.size() == 0) {
			trackList = driver.findElements(tracks);
		}
		for (WebElement ele : trackList) {
			sb.append(ele.getAttribute("innerText")).append("\n");
		}
		return sb.toString();
	}
	
	private String processIntro() {
		if (isElementPresent(showMore)) {
			driver.findElement(showMore).click();
			if (isElementPresent(intro)) {
				return driver.findElement(intro).getAttribute("innerText");
			}
		} else {
			if (isElementPresent(intro2)) {
				return driver.findElement(intro2).getAttribute("innerText");//textContent, innerHTML
			}
		}
		return "";
	}
	
	private boolean isElementPresent(By by) {
		List<WebElement> results = driver.findElements(by);
		return results.size() > 0;
	}
	
	private WebElement filterSearchResults(String singer, String album) {
		List<WebElement> results = driver.findElements(searchResults);
		if (results == null || results.size() == 0) {
			return null;
		}
		for (WebElement ele : results) {
			String title = ele.getAttribute("title").toLowerCase();
			if (StringUtils.contains(title, album.toLowerCase())) {
				return ele;
			}
		}
		return results.get(0);
	}

}
