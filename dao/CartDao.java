package com.onlinefoodplaza.dao;


import java.util.List;

import com.onlinefoodplaza.pojo.Cart_20525;

public interface CartDao {
	public boolean addToCart(Cart_20525 crt);
	List<Cart_20525> showCart(String email);
	boolean deleteCart();
	 boolean deleteCartByFoodid(int id);
}
