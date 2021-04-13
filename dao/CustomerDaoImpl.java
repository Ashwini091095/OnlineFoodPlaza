package com.onlinefoodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinefoodplaza.dbconnection.DBConnection;
import com.onlinefoodplaza.pojo.Customer_20525;

public class CustomerDaoImpl implements CustomerDao {
	ResultSet rs=null;			
	

	Customer_20525 c=new Customer_20525();
	
	public boolean addCust(Customer_20525 c) {
		try {
		Connection con=DBConnection.getConnection();
		String sql="insert into Customer_20525 (cust_name,cust_addr,cust_email,cust_pass,cust_contact) values (?,?,?,?,?) ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.getCname());
			ps.setString(2, c.getCaddrs());
			ps.setString(3, c.getCemail());
			ps.setString(4, c.getCpass());
			ps.setString(5, c.getCcont());
			int i=ps.executeUpdate();
			if(i>0)
			{return true;}
			else{return false;}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}

		
		return false;
	}

	@Override
	public boolean updateCust(Customer_20525 c) {
		try {
		Connection con=DBConnection.getConnection();
		String sql="update Customer_20525 set cust_name=?, cust_addr=? ,cust_email=?,cust_contact=? where cust_id=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, c.getCname());
		ps.setString(2, c.getCaddrs());
		ps.setString(3, c.getCemail());
	/*	ps.setString(4, c.getCpass());*/
		ps.setString(4, c.getCcont());
		ps.setInt(5, c.getCid());
		int i=ps.executeUpdate();

		if(i>0)
		{return true;}
		else{return false;}
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}

	

	public boolean deleteCust(int custId) {
		try {
		Connection con=DBConnection.getConnection();
		String sql="delete from Customer_20525 where cust_id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, custId);
		int x=ps.executeUpdate();
		if(x>0)
		{return true;}		

		else{return false;}	
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Customer_20525> showAllCust() {
		List<Customer_20525> li=new ArrayList<Customer_20525>();
		try 
		{
			Connection con=DBConnection.getConnection();
			String sql="select * from Customer_20525";
			PreparedStatement ps=con.prepareStatement(sql);
			 rs=ps.executeQuery();
			while(rs.next())
			{
				Customer_20525 c=new Customer_20525();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setCaddrs(rs.getString(3));
				c.setCemail(rs.getString(4));
				//c.setCpass(rs.getString(5));
				c.setCcont(rs.getString(6));
				li.add(c);
				
			}
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return li;
	}

	@Override
	public Customer_20525 showCustById(int custId) {
		try {
			Connection con=DBConnection.getConnection();
			String sql="select * from Customer_20525 where cust_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,custId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setCaddrs(rs.getString(3));
				c.setCemail(rs.getString(4));
				c.setCpass(rs.getString(5));
				c.setCcont(rs.getString(6));
				
			}




		}	
		catch (SQLException e) {

			e.printStackTrace();
			}
		return c;
	}
}
