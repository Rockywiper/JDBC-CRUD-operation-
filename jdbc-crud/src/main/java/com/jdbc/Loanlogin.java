package com.jdbc;
import java.util.Scanner;
import java.sql.*;

public class Loanlogin 
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{	
		int sign;
		int sno = 0;
		String name = null;
		String lname = null;
		String email = null;
		String password = null;
		String aadhar = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan", "root", "prasanth15");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from signup");
		
		Scanner log = new Scanner(System.in);
		System.out.println("For signup press [1], For login press [2], For exit press[3] : ");
		sign = log.nextInt();
		
		switch(sign)
		{
		case 1:
		{
			System.out.println("Enter the sno :");
			sno = log.nextInt();
			
			Scanner n = new Scanner(System.in);
			System.out.println("Enter your name : ");
			name = n.next();
			
			Scanner l = new Scanner(System.in);
			System.out.println("Enter your last name : ");
			lname = l.next();
			
			Scanner mail = new Scanner(System.in);
			System.out.println("Enter your email : ");
			email = mail.next();
			
			Scanner p = new Scanner(System.in);
			System.out.println("Create your new password : ");
			password = p.next();
			
			Scanner num = new Scanner(System.in);
			System.out.println("Enter your aadhar number : ");
			aadhar = num.next();
			
			int i = st.executeUpdate("insert into signup values('"+sno+"','"+name+"','"+lname+"','"+email+"','"+password+"','"+aadhar+"')");
			System.out.println("\t\t\tSuccessfully signed up");
		}
		case 2:
		{		
			String user;
		    String pass;
			
			Scanner sc1 = new Scanner(System.in);
			System.out.println("username : ");
			name = sc1.nextLine();
			
			System.out.println("password : ");
			pass = sc1.nextLine();
			
			while(rs.next())
			{
				if(name.equals(rs.getString("name")) && pass.equals(rs.getString("create_password")))
				{
					System.out.println("Successfully loggedin");
					//break;
				}
				else
				{
					System.out.println("Invalid username or password");
					
				}
			}
		}
		case 3:
		{
			System.out.println("\t\t\tThank you for visiting our webpage");
		}
		
		}		
	}
}