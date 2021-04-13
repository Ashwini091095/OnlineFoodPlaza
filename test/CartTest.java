package com.onlinefoodplaza.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.onlinefoodplaza.dao.CartDaoImpl;
import com.onlinefoodplaza.pojo.Cart_20525;

public class CartTest {

	public static void main(String[] args) {
		List<Cart_20525> li=new  ArrayList<Cart_20525>();

		Scanner sc=new Scanner(System.in);
		CartDaoImpl cartdao=new CartDaoImpl();
		Cart_20525 crt=new Cart_20525();
		int fid,fquantity;
		String custemail;
		while(true)
		{
			System.out.println("1.Add to Cart \n2.Show Cart\n3.Delete Cart\n4.Exit");
			System.out.println("Enter choice");
			int ch=sc.nextInt();

			switch(ch){
			case 1:
				System.out.println("Add to cart");
				System.out.println("Enter Food id");
				fid=sc.nextInt();
				
				System.out.println("enter Food Quantity");
				fquantity=sc.nextInt();
				
				System.out.println("Enter customer email");
				custemail=sc.next();
				
				crt.setFid(fid);
				crt.setFquantity(fquantity);
				crt.setCustemail(custemail);
				
				boolean f =cartdao.addToCart(crt);
				if(f==true)
				{System.out.println("Food Added sucessfully");}
				else{System.out.println("Food is not added to Cart");}
				break;
				
			case 2:
				System.out.println("Showing Cart");
				
				
				li=cartdao.showCart();
				Iterator<Cart_20525> itr=li.iterator();

				while (itr.hasNext()) {
					System.out.println(itr.next());
					}
				break;
			case 3:
				System.out.println("Deleting Cart");
				
                  boolean f1=cartdao.deleteCart();
                  if(f1==true){System.out.println("cart Deleted");}
                  else{System.out.println("deletion Failed");}
				break;
				
			case 4:
				System.out.println("Thank You");
				System.exit(0);
				default:
					System.out.println("plz enter valid choice number within 1 to 4");
			}
		}

	}

}
