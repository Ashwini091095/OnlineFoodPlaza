package com.onlinefoodplaza.pojo;

public class Cart {
	private int cartid;
	private int fid;
	private String fname;
	private double fprice;
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", fid=" + fid + ", fname=" + fname + ", fprice=" + fprice + "]";
	}
	public Cart(int cartid, int fid, String fname, double fprice) {
		super();
		this.cartid = cartid;
		this.fid = fid;
		this.fname = fname;
		this.fprice = fprice;
	}
	public Cart() {
super();	}
	

}
