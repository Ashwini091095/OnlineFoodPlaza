package com.onlinefoodplaza.test;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.onlinefoodplaza.dao.FoodDao_20525;
import com.onlinefoodplaza.dao.FoodDaoImpl_20525;
import com.onlinefoodplaza.pojo.Food_20525;

public class FoodTest_20525 {

	public static void main(String[] args)   {
		FoodDaoImpl_20525 fdao = new FoodDaoImpl_20525();
		List<Food_20525> li=new ArrayList<Food_20525>();
		

		int fid,fquntity;
		String fname,fcategory;
		double fprice;
		
		
		Food_20525 f=new Food_20525();

		Scanner sc=new Scanner(System.in);
		while(true){
			

			System.out.println("Enter the option you want to perform ");
		System.out.println("1.Add Food\n2.Update Food\n3.Delete Food\n4.Show All\n5.Show By Id\n6.Exit");
		int ch=sc.nextInt();
		switch (ch) {
		case 1:
			System.out.println("Add Food");
			System.out.println("Enter Name");
			fname=sc.next();
			
			System.out.println("Enter Category");
			fcategory=sc.next();
			
			System.out.println("Enter Quantity");
			fquntity=sc.nextInt();
			
			System.out.println("Enter Price");
			fprice=sc.nextDouble();			
			
			f.setFname(fname);
			f.setFcategory(fcategory);
			f.setFqauntity(fquntity);
			f.setFprice(fprice);
			boolean	flag = fdao.addFood(f);
			if (flag==true)
			{
				System.out.println("Food Record Succesfully Added");
			}
			else
			{System.out.println("Failed");}
			break;
			
		case 2:
			System.out.println("Enter food id to Update");
			fid=sc.nextInt();
			
			System.out.println("Enter New Name");
			fname=sc.next();
			
			System.out.println("Enter New Category");
			fcategory=sc.next();
			
			System.out.println("Enter New Quantity");
			fquntity=sc.nextInt();
			
			System.out.println("Enter New Price");
			fprice=sc.nextDouble();			
			
			f.setFname(fname);
			f.setFcategory(fcategory);
			f.setFqauntity(fquntity);
			f.setFprice(fprice);
			f.setFid(fid);
			boolean	flag1 = fdao.updateFood(f);
			if (flag1==true)
			{
				System.out.println("Succesfully Updated");
			}
			else
			{System.out.println("Not Updated");}
			
			
			break;
			
		case 3:
			System.out.println("Deleting Food Details");
			System.out.println("Enter Food Id");
			fid=sc.nextInt();
			
			//f.setFid(fid);
			
			boolean falg3=fdao.deleteFood(fid);
			if (falg3==true)
			{
				System.out.println("Succesfully Deleted");
			}
			else
			{System.out.println("Deletion Failed");}
			
			
			break;
			
		case 4:
			
			System.out.println("Showing all Details");
			li=fdao.showAll();
			
			Iterator<Food_20525> itr=li.iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}
			
			break;
			
		case 5:
			
			System.out.println("Search record by id");
			System.out.println("Enter food id");
			fid=sc.nextInt();
			Food_20525 f1=fdao.showByid(fid);
			System.out.println(f1);
			
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
