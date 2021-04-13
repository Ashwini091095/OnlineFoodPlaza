package com.onlinefoodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinefoodplaza.dbconnection.DBConnection;
import com.onlinefoodplaza.pojo.Cart_20525;

public class CartDaoImpl implements CartDao{
	ResultSet rs=null;		
	PreparedStatement ps=null; 
	@Override
	public boolean addToCart(Cart_20525 crt) {
		try {
			Connection con=DBConnection.getConnection();
		String sql="select food_name, food_price from Food_20525 where food_id=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, crt.getFid());
		rs=ps.executeQuery();
		while(rs.next())
		{
			crt.setFname(rs.getString(1));
			crt.setFprice(rs.getDouble(2));
		}
		String sql1="insert into cart_20525(food_id, food_name, food_price, food_quantity, cust_email) values (?,?,?,?,?)";
		ps=con.prepareStatement(sql1);
		ps.setInt(1, crt.getFid());
		ps.setString(2, crt.getFname());
		ps.setDouble(3, crt.getFprice());
		ps.setInt(4, crt.getFquantity());
		ps.setString(5, crt.getCustemail());
		int i=ps.executeUpdate();
		if(i>0)
		{return true;}
		else{return false;}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Cart_20525> showCart(String email) {
		List<Cart_20525>   li=new ArrayList<Cart_20525>();

		try {

			Connection con=DBConnection.getConnection();
			String sql="select * from cart_20525 where cust_email=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Cart_20525 c=new Cart_20525();
				c.setCartid(rs.getInt(1));
				c.setFid(rs.getInt(2));
				c.setFname(rs.getString(3));
				c.setFprice(rs.getDouble(4));
				c.setFquantity(rs.getInt(5));
				c.setCustemail(rs.getString(6));
				li.add(c);	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public boolean deleteCart() {
		try {
			Connection con=DBConnection.getConnection();
			String sql="delete from cart_20525";
			ps=con.prepareStatement(sql);
			int p=ps.executeUpdate();
			if(p>0){return true;}
			else {return false;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteCartByFoodid(int id) {
		try {	
		Connection con=DBConnection.getConnection();
		String sql="delete from cart_20525 where food_id=?";
		ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		int p=ps.executeUpdate();
		if(p>0){return true;}
		else {return false;}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

}
