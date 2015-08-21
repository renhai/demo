package com.sankuai.meituan.test;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8422059950250071154L;
	private int id;
	private String name;
	
	private List<String> childs;
	
	public List<String> getChilds() {
		return childs;
	}
	public void setChilds(List<String> childs) {
		this.childs = childs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", childs=" + childs
				+ "]";
	}
	
}
