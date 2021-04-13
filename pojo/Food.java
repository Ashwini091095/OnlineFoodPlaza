package com.onlinefoodplaza.pojo;

public class Food {
	private int fid;
	private String fname;
	private String fcategory;
	private int fqauntity;
	private double fprice;
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
	public String getFcategory() {
		return fcategory;
	}
	public void setFcategory(String fcategory) {
		this.fcategory = fcategory;
	}
	public int getFqauntity() {
		return fqauntity;
	}
	public void setFqauntity(int fqauntity) {
		this.fqauntity = fqauntity;
	}
	public double getFprice() {
		return fprice;
	}
	public void setFprice(double fprice) {
		this.fprice = fprice;
	}
	@Override
	public String toString() {
		return "Food [fid=" + fid + ", fname=" + fname + ", fcategory=" + fcategory + ", fqauntity=" + fqauntity
				+ ", fprice=" + fprice + "]";
	}
	public Food(int fid, String fname, String fcategory, int fqauntity, double fprice) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.fcategory = fcategory;
		this.fqauntity = fqauntity;
		this.fprice = fprice;
	}
	

}
