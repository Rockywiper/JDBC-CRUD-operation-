package com.jdbc;
import java.sql.*;

public class JdbcInsert 
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		int id=7;
		String name="Dhanu";
		int age=21;
		int mobile=9812;
		String source="Andhra pradesh";
		String destination="Jammu";
				
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airbooking", "root", "prasanth15");
		Statement st = con.createStatement();
		
		int i = st.executeUpdate("insert into passengers values('"+id+"','"+name+"','"+mobile+"','"+age+"','"+source+"','"+destination+"')");
	}

}
