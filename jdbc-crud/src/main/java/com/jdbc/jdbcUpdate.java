package com.jdbc;
import java.sql.*;

public class jdbcUpdate 
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		String destination = "Jammu";
		int id = 2;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airbooking","root","prasanth15");
		Statement st = con.createStatement();
		
		int i = st.executeUpdate("update passengers set destination='"+destination+"' where id='"+id+"'");
	}
}
