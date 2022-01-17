package com.basha.bean;

public class BillGeneration {
	private Product product;
	private double gst;
	private double transferCharge;
	private double total;

	public BillGeneration() {

	}

	public BillGeneration(Product product, double gst, double transferCharge, double total) {
		super();
		this.product = product;
		this.gst = gst;
		this.transferCharge = transferCharge;
		this.total = total;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public void setTransferCharge(double transferCharge) {
		this.transferCharge = transferCharge;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getGst() {
		return gst;
	}

	public double getTransferCharge() {
		return transferCharge;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "BillGeneration [product=" + product + ", gst=" + gst + ", transferCharge=" + transferCharge + ", total="
				+ total + "]";
	}
}
