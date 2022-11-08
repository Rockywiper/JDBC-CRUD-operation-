package com.jdbc;
import java.sql.*;

public class JdbcDemo 
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airbooking", "root", "prasanth15");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from passengers");
		
		while(rs.next())
		{
			//rs.getInt("id");
			System.out.println(rs.getLong("id")+" : "+rs.getString("name")+" : "+rs.getLong("mobile")+" : "+rs.getInt("age")+" : "+rs.getString("source")+" : "+rs.getString("destination"));
		}
	}
}
