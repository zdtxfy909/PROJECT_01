package com.mystudy.cafetest.vo;

public class OrdersdetailVO {
	private int menuId;
	private int orderId;
	protected int count;
//	String name; //menu
//	int price; //menu
//	String orderdate; //sales
	
	
	public OrdersdetailVO() {}
	
//	public OrdersdetailVO(int menuId, int orderId, int count, String name, int price, String orderdate) {
//		super();
//		this.menuId = menuId;
//		this.orderId = orderId;
//		this.count = count;
//		this.name = name;
//		this.price = price;
//		this.orderdate = orderdate;
//	}

	
	public OrdersdetailVO(int menuId, int orderId, int count) {
		super();
		this.menuId = menuId;
		this.orderId = orderId;
		this.count = count;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "OdersdetailVO [menuId=" + menuId + ", orderId=" + orderId + ", count=" + count + "]";
	}
	
	

}