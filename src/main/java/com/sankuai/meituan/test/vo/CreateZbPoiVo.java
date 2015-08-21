package com.sankuai.meituan.test.vo;

import java.util.ArrayList;
import java.util.List;

public class CreateZbPoiVo {
	public Integer zbPoiId;
	private String pointName;
	private Integer longitude;
	private Integer latitude;
	private Integer adjustLongitude;
	private Integer adjustLatitude;
	private Integer precision;
	private String address;
	private String phone;
	List<ZbPoiPhotoVo> photoList = new ArrayList<ZbPoiPhotoVo>();
	
	public Integer getZbPoiId() {
		return zbPoiId;
	}

	public void setZbPoiId(Integer zbPoiId) {
		this.zbPoiId = zbPoiId;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public Integer getLongitude() {
		return longitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<ZbPoiPhotoVo> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<ZbPoiPhotoVo> photoList) {
		this.photoList = photoList;
	}

	public Integer getAdjustLongitude() {
		return adjustLongitude;
	}

	public void setAdjustLongitude(Integer adjustLongitude) {
		this.adjustLongitude = adjustLongitude;
	}

	public Integer getAdjustLatitude() {
		return adjustLatitude;
	}

	public void setAdjustLatitude(Integer adjustLatitude) {
		this.adjustLatitude = adjustLatitude;
	}

	public Integer getPrecision() {
		return precision;
	}

	public void setPrecision(Integer precision) {
		this.precision = precision;
	}

	@Override
	public String toString() {
		return "CreateZbPoiVo [zbPoiId=" + zbPoiId + ", pointName=" + pointName
				+ ", longitude=" + longitude + ", latitude=" + latitude
				+ ", adjustLongitude=" + adjustLongitude + ", adjustLatitude="
				+ adjustLatitude + ", precision=" + precision + ", address="
				+ address + ", phone=" + phone + ", photoList=" + photoList
				+ "]";
	}
	
}
