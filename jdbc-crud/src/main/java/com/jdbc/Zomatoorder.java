package com.jdbc;
import java.util.Scanner;
import java.sql.*;

public class Zomatoorder 
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery", "root", "prasanth15");
		Statement st = con.createStatement();
		ResultSet rso = st.executeQuery("select * from orders");
		
		while(rso.next())
		{
			//rso.getInt("id");
			System.out.println(rso.getLong("sno")+" : "+rso.getString("maindish")+" and "+rso.getString("softdrink"));
		}
		System.out.println("Please choose the maindish you wanted with the number given before the maindish, the softdrink is absolutely free.");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the maindish with the number : ");
		int num = sc.nextInt();
		while(rso.next())
		{
			if(rso.getLong("sno")==num)
			{
				System.out.println("");
			}
		}
	}
}
