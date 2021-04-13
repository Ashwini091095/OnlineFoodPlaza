package com.onlinefoodplaza.dao;


import java.sql.SQLException;
import java.util.List;

import com.onlinefoodplaza.pojo.Food_20525;

public interface FoodDao_20525 {
	boolean addFood(Food_20525 f) throws SQLException;
	boolean updateFood(Food_20525 f);
	boolean deleteFood(int id);
	List<Food_20525> showAll();
	Food_20525 showByid(int id);
	List<Food_20525> showByFoodName(String fname);

}
