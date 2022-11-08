package com.jdbc;
import java.util.Scanner;
import java.sql.*;
public class Zomatologin 
{
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery", "root", "prasanth15");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from login");
		
		String user;
	    String pass;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("username : ");
		user = sc.nextLine();
		
		while(rs.next())
		{
			if(rs.getString("username").equals(user))
			{
				System.out.println("password : ");
				pass = sc.nextLine();
				if(rs.getString("password").equals(pass))
				{
					System.out.println("Successfully loggedin");
					break;
				}
				else
				{
					System.out.println("Please enter the correct password");
					break;
				}
			}
			else
			{
				System.out.println("Please enter the correct username");
			}
		}
		
	}
}
