package com.nikhil.bean;

import java.util.List;

public class Order {
	private Long id;
	private String customerEmail;
    private String customerAddress;
    private List<OrderItem> items;
    
	public Order(Long id, String customerEmail, String customerAddress, List<OrderItem> items) {
		super();
		this.id = id;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.items = items;
	}
	
    
    public Long getId() {
		return id;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	

}
