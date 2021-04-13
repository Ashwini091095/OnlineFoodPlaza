package com.onlinefoodplaza.pojo;

public class Order1 {
	private int ordid;
	private String cemail;
	private double totbill;
	public int getOrdid() {
		return ordid;
	}
	public void setOrdid(int ordid) {
		this.ordid = ordid;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public double getTotbill() {
		return totbill;
	}
	public void setTotbill(double totbill) {
		this.totbill = totbill;
	}
	@Override
	public String toString() {
		return "Order1 [ordid=" + ordid + ", cemail=" + cemail + ", totbill=" + totbill + "]";
	}
	public Order1(int ordid, String cemail, double totbill) {
		super();
		this.ordid = ordid;
		this.cemail = cemail;
		this.totbill = totbill;
	}
	

}
