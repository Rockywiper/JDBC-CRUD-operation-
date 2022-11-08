package com.jdbc;
import java.sql.*;

public class JdbcDelete 
{
	public static void main() throws ClassNotFoundException, SQLException
	{
		String name = "Dhanu";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "prasanth15");
		Statement st = con.createStatement();
		
		//int i = st.executeUpdate("delete from passengers where name='"name"'");
	}
}
