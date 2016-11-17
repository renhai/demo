package me.renhai.selenium.pages;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class AlbumInfo {
	private String name;
	private String performer;
	private String genre;
	private String releaseTime;
	private String publisher;
	private String cover;
	private String intro;
	private String tracks;
	
	private Map<String, String> attrs = new HashMap<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = StringUtils.trimToEmpty(name);
	}
	public String getPerformer() {
		return performer;
	}
	public void setPerformer(String performer) {
		this.performer = performer;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = StringUtils.trimToEmpty(intro);
	}
	public String getTracks() {
		return tracks;
	}
	public void setTracks(String tracks) {
		this.tracks = StringUtils.trimToEmpty(tracks);
	}
	
	public void setAttrs(String attrStr) {
		attrStr = StringUtils.trimToEmpty(attrStr);
		String[] attrArr = StringUtils.split(attrStr, "\n");
		for (String line : attrArr) {
			int index = line.indexOf(':');
			if (index <= 0) continue;
			String attr = StringUtils.trimToEmpty(line.substring(0, index));
			String value = StringUtils.trimToEmpty(line.substring(index + 1));
			attrs.put(attr, value);
		}
		setPerformer(attrs.get("表演者"));
		setGenre(attrs.get("流派"));
		setReleaseTime(attrs.get("发行时间"));
		setPublisher(attrs.get("出版者"));
	}
	@Override
	public String toString() {
		return "AlbumInfo [name=" + name + ", performer=" + performer + ", genre=" + genre + ", releaseTime="
				+ releaseTime + ", publisher=" + publisher + ", cover=" + cover + ", intro=" + intro + ", tracks="
				+ tracks + "]";
	}
	
	
	
}
