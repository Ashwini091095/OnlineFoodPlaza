package com.onlinefoodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinefoodplaza.dbconnection.DBConnection;
import com.onlinefoodplaza.pojo.Food_20525;

public class FoodDaoImpl_20525 implements FoodDao_20525 {

	Food_20525 f=new Food_20525();
	ResultSet rs=null;
	@Override
	public boolean addFood(Food_20525 f)
	{
		try {	
			Connection con=DBConnection.getConnection();
			String sql="insert into Food_20525(food_name,food_category,food_qauntity,food_price) values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, f.getFname());
			ps.setString(2, f.getFcategory());
			ps.setInt(3, f.getFqauntity());
			ps.setDouble(4, f.getFprice());
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
	public boolean updateFood(Food_20525 f) {
		try {
			Connection con=DBConnection.getConnection();
			String sql="update Food_20525 set food_name=?, food_category=?, food_qauntity=?, food_price=? where food_id=? ";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, f.getFname());
			ps.setString(2, f.getFcategory());
			ps.setInt(3, f.getFqauntity());
			ps.setDouble(4, f.getFprice());
			ps.setInt(5, f.getFid());

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
	public boolean deleteFood(int id) {
		try {
			Connection con=DBConnection.getConnection();
			String sql="delete from Food_20525 where food_id=? ";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
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
	public List<Food_20525> showAll() {
		List<Food_20525>   li=new ArrayList<Food_20525>();
		try {

			Connection con=DBConnection.getConnection();
			String sql="select * from Food_20525";
			PreparedStatement ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Food_20525 f=new Food_20525();
				f.setFid(rs.getInt(1));
				f.setFname(rs.getString(2));
				f.setFcategory(rs.getString(3));
				f.setFqauntity(rs.getInt(4));
				f.setFprice(rs.getInt(5));
				li.add(f);
			}
		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Food_20525 showByid(int id) {
		try {
			Connection con=DBConnection.getConnection();
			String sql="select * from Food_20525 where food_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,id);

			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				f.setFid(rs.getInt(1));
				f.setFname(rs.getString(2));
				f.setFcategory(rs.getString(3));
				f.setFqauntity(rs.getInt(4));
				f.setFprice(rs.getDouble(5));
			}
		}catch (SQLException e) {

			e.printStackTrace();
		}

		return f;
	}

	@Override
	public
	 List<Food_20525> showByFoodName(String fname) {
			List<Food_20525>   li=new ArrayList<Food_20525>();

		Food_20525 f=null;
		try {
			Connection con=DBConnection.getConnection();
		String sql="select food_name,food_category,food_price from Food_20525 where food_name=?";
		
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, fname);
			ResultSet rs=ps.executeQuery();
			
				while (rs.next()) 
				{
					f=new Food_20525();
					f.setFname(rs.getString(1));
					f.setFcategory(rs.getString(2));
					f.setFprice(rs.getDouble(3));
					li.add(f);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return li;
	}

}

