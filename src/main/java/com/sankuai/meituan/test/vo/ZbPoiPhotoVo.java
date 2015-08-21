package com.sankuai.meituan.test.vo;

public class ZbPoiPhotoVo {
	public Integer zbPoiId;
	public Integer type;
	public String url;
	
	public Integer getZbPoiId() {
		return zbPoiId;
	}
	public void setZbPoiId(Integer zbPoiId) {
		this.zbPoiId = zbPoiId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "ZbPoiPhotoVo [zbPoiId=" + zbPoiId + ", type=" + type + ", url="
				+ url + "]";
	}
	
}
