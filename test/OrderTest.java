package com.onlinefoodplaza.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.onlinefoodplaza.dao.CartDaoImpl;
import com.onlinefoodplaza.dao.Order1DaoImpl;
import com.onlinefoodplaza.pojo.Customer_20525;
import com.onlinefoodplaza.pojo.Order1_20525;

public class OrderTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String cust_email;
		Order1DaoImpl odao=new Order1DaoImpl();
		CartDaoImpl art=new CartDaoImpl();
		List<Order1_20525> li=new ArrayList<Order1_20525>();
		while(true)
		{
			System.out.println("1.Place Order\n2.Show Order by Email\n3.Show All\n4.Delete Order by cust_email\n5.Exit");
			int ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				System.out.println("Place Order");
				System.out.println("Enter Email");
				cust_email=sc.next();
				boolean b=odao.placeOrder(cust_email);
				if(b==true)
				{System.out.println("Oredr placed Sucelly");
				art.deleteCart();
				}
				
				else{
					System.out.println("Order not palced");}
				break;
			case 2:
				System.out.println("Showing Order by email");
				System.out.println("Enter Email");
				cust_email=sc.next();
				Order1_20525 b1=odao.showOrderByEmail(cust_email);
				System.out.println(b1);
				break;
				
			case 3:
				System.out.println("Showing All details");
                   li=odao.showAllOrder();
				
				Iterator<Order1_20525> itr=li.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
					}
				break;
			
			case 4:
				System.out.println("Deleting Order");
				System.out.println("Enter Email Address");
				cust_email=sc.next();
				
				boolean b2=odao.deleteOrderByEmail(cust_email);
				if(b2==true)
				{System.out.println("Deletipn of order is succesfull");}
				else {
					System.out.println("Deletion Failed");
				}
				break;
			case 5:
				System.out.println("Thank you Come again");
				System.exit(0);
				default:
					System.out.println("You have Entered wrong optin please enter a valid option");
			}

		}

	}

}
