package com.nikhil.bean;

import java.math.BigDecimal;

public class OrderItem {
	private Long id;
	private Long productId;
    private int quantity;
    private BigDecimal productPrice;
    
	public OrderItem(Long id, Long productId, int quantity, BigDecimal productPrice) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.productPrice = productPrice;
	}
	
	
    public Long getId() {
		return id;
	}
	public Long getProductId() {
		return productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	

}
