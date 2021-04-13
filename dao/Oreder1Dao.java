package com.onlinefoodplaza.dao;


import java.util.List;

import com.onlinefoodplaza.pojo.Order1_20525;

public interface Oreder1Dao {
	/*public boolean placeOrder(String cust_email);*/
	public Order1_20525 showOrderByEmail(String cust_email);
	List<Order1_20525> showAllOrder();
	public boolean deleteOrderByEmail(String cust_email) ;
	public boolean placeOrder(String cust_email, double totalBill);
}
