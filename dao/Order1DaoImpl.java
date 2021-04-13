package com.onlinefoodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.onlinefoodplaza.dbconnection.DBConnection;
import com.onlinefoodplaza.pojo.Order1_20525;

public class Order1DaoImpl implements Oreder1Dao {
	CartDaoImpl cdao=new CartDaoImpl();
	ResultSet rs;
    
	
/*	public boolean placeOrder(String cust_email) {
		Order1_20525 o=new Order1_20525();

		try {
			Connection con=DBConnection.getConnection();
		String sql="select sum(food_quantity*food_price) as 'Total_Bill' from cart_20525 where cust_email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cust_email);
		rs=ps.executeQuery();
		while(rs.next()){
		o.setTotbill(rs.getDouble("Total_Bill"));
		}
		//System.out.println("thank you for shopping with us\n  your total bill is "+o.getTotbill());
		String sql2="insert into order1_20525(cust_email,total_bill,date) values (?,?,sysdate())";
		ps=con.prepareStatement(sql2);
		ps.setString(1, cust_email);
		ps.setDouble(2, o.getTotbill());
		int p=ps.executeUpdate();
		if(p>0){return true;}
		else{return false;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
*/
	@Override
	public Order1_20525 showOrderByEmail(String cust_email) {
		Order1_20525 o=new Order1_20525();

		try {
			Connection con=DBConnection.getConnection();
		String sql="select * from order1_20525 where cust_email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cust_email);
		rs=ps.executeQuery();
		
		while(rs.next())
		{
		o.setOrdid(rs.getInt(1));
		o.setCemail(rs.getString(2));
		o.setTotbill(rs.getDouble(3));
		o.setDate(rs.getString(4));	
}
		}
		 catch (SQLException e) {
				e.printStackTrace();
			}
			
		return o;
	}

	@Override
	public List<Order1_20525> showAllOrder() {
		List<Order1_20525> li=new ArrayList<Order1_20525>();
		

		try {	Connection con=DBConnection.getConnection();
		String sql="select * from order1_20525";
		PreparedStatement ps;
		
			ps = con.prepareStatement(sql);
			rs=ps.executeQuery();
		while(rs.next())
		{
			Order1_20525 o1=new Order1_20525();

			o1.setOrdid(rs.getInt(1));
			o1.setCemail(rs.getString(2));
			o1.setTotbill(rs.getDouble(3));
			o1.setDate(rs.getString(4));
			li.add(o1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public boolean deleteOrderByEmail(String cust_email) {

		try {	Connection con=DBConnection.getConnection();
		String sql="delete from order1_20525 where cust_email=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, cust_email);
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
	
	public boolean placeOrder(String cust_email, double totalBill) {
		CartDaoImpl crtdao=new CartDaoImpl();
		try {Connection con=DBConnection.getConnection();
		String sql2="insert into order1_20525(cust_email,total_bill,date) values (?,?,sysdate())";
		PreparedStatement ps;
		ps = con.prepareStatement(sql2);
		
		ps.setString(1, cust_email);
		ps.setDouble(2, totalBill);
		int p=ps.executeUpdate();
		if(p>0){
			crtdao.deleteCart();
			return true;}
		else{return false;}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;}


}
