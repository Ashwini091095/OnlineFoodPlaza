package com.onlinefoodplaza.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.onlinefoodplaza.dao.CustomerDaoImpl;
import com.onlinefoodplaza.pojo.Customer_20525;

public class CustomerTest {

	public static void main(String[] args) {
		int cid;
		String cname,caddrs,cemail,cpass,ccont;
		Scanner sc=new Scanner(System.in);
		CustomerDaoImpl cdao=new CustomerDaoImpl();
		Customer_20525 c=new Customer_20525();
		List<Customer_20525> cli=new ArrayList<Customer_20525>();
		while(true){
		System.out.println("1.Add Customer Details \n2.Update Customer \n3.Delete Customer \n4.Show All Customer \n5.Show Customer by Id\n6.Exit");
		int ch=sc.nextInt();
		
		switch(ch)
		{
		case 1:
			System.out.println("Add new Customer");
			System.out.println("Enter Name of Customer");
			cname=sc.next();
			
			System.out.println("Enter Address of Customer");
			caddrs=sc.next();
			
			System.out.println("Enter Email Address");
			cemail=sc.next();
			
			System.out.println("Enter Customer Password");
			cpass=sc.next();
			
			System.out.println("Enter Contact Number");
			ccont=sc.next();
			
			c.setCname(cname);
			c.setCaddrs(caddrs);
			c.setCemail(cemail);
			c.setCpass(cpass);
			c.setCcont(ccont);
			
			boolean ch1=cdao.addCust(c);
			if(ch1==true){System.out.println("Customer Added Sucesfully");}
			else {System.out.println("Customer updation failed");	}
			break;
			
		case 2:System.out.println("Udating Customer details");
			System.out.println("Enter customer Id number");
			cid=sc.nextInt();
			
			System.out.println("Enter New Name of Customer");
			cname=sc.next();
			
			System.out.println("Enter New Address of Customer");
			caddrs=sc.next();
			
			System.out.println("Enter New Email Address");
			cemail=sc.next();
			
			System.out.println("Enter New Customer Password");
			cpass=sc.next();
			
			System.out.println("Enter new Contact Number");
			ccont=sc.next();
			
			c.setCname(cname);
			c.setCaddrs(caddrs);
			c.setCemail(cemail);
			c.setCpass(cpass);
			c.setCcont(ccont);
			c.setCid(cid);
			
			boolean ch2=cdao.updateCust(c);
			if(ch2==true){System.out.println("Customer Updated Sucesfully");}
			else {System.out.println("Customer updation failed");	}
			break;
			case 3:
				System.out.println("Deleting Customer");
				System.out.println("Enter customer Id");
				cid=sc.nextInt();
				
				boolean ch3=cdao.deleteCust(cid);
				if (ch3==true)
				{
					System.out.println("Succesfully Deleted");
				}
				else
				{System.out.println("Deletion Failed");}
				break;
				
			case 4:
				System.out.println("Showing all customer details");
				cli=cdao.showAllCust();
				
				Iterator<Customer_20525> itr=cli.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
					
				}
				
				
				break;
				
			case 5:
				System.out.println("Showing Customer records by Id");
				System.out.println("Enter Customer number");
				cid=sc.nextInt();
				Customer_20525 cd=cdao.showCustById(cid);
				System.out.println(cd);

				break;
			case 6:

				System.out.println("Bye");
				System.exit(0);

			default:
				System.out.println("Invalid option select please select between 1 to 6");
				
				break;
				

			
		
		}
		}
	}

}
