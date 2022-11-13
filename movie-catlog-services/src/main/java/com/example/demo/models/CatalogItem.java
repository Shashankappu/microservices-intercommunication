package com.example.demo.models;


public class CatalogItem {
	
	private String name;
	private String desc;
	private int rating;
	
	public CatalogItem(String name,String desc,int rating) {
		this.name = name;
		this.desc =desc;
		this.rating=rating;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
