package com.nikhil.bean;

import java.util.List;

public class OrderList {
	private List<Order> orders;

	public OrderList(List<Order> orders) {
		super();
		this.orders = orders;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public OrderList() {
		super();
		// TODO Auto-generated constructor stub
	}

}
