package com.onlinefoodplaza.pojo;

public class Customer {
	private int cid;
	private String cname;
	private String caddrs;
	private String cemail;
	private String cpass;
	private String ccont;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCaddrs() {
		return caddrs;
	}
	public void setCaddrs(String caddrs) {
		this.caddrs = caddrs;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	public String getCcont() {
		return ccont;
	}
	public void setCcont(String ccont) {
		this.ccont = ccont;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", caddrs=" + caddrs + ", cemail=" + cemail + ", cpass="
				+ cpass + ", ccont=" + ccont + "]";
	}
	public Customer(int cid, String cname, String caddrs, String cemail, String cpass, String ccont) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.caddrs = caddrs;
		this.cemail = cemail;
		this.cpass = cpass;
		this.ccont = ccont;
	}

	
}
