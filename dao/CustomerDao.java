package com.onlinefoodplaza.dao;

import java.util.List;

import com.onlinefoodplaza.pojo.Customer_20525;

public interface CustomerDao {
	public boolean addCust(Customer_20525 c);
	public boolean updateCust(Customer_20525 c);
	public boolean deleteCust(int custId);
	public List<Customer_20525> showAllCust();
	public Customer_20525 showCustById(int custId);
	
	

}
