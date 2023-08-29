package com.mystudy.cafetest.vo;

public class MenuVO {
	int menuid;
	String name;
	int price;
	
	
	public MenuVO() {}


	public MenuVO(int menuid) {
		super();
		this.menuid = menuid;
	}


	public MenuVO(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}


	public MenuVO(int menuid, String name, int price) {
		this.menuid = menuid;
		this.name = name;
		this.price = price;
	}


	public int getMenuid() {
		return menuid;
	}


	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "MenuVO [menuid=" + menuid + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
}
