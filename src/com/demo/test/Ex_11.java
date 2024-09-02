package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex_11 {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
//		ResultSet rs = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306";
			con = DriverManager.getConnection(url, "root", "7980784725");
			System.out.println("connected");
			ps= con.prepareStatement("insert into webtechtesing.student values(?,?,?)");
			ps.setString(1,"biriyani");
			ps.setInt(2,2);
			ps.setInt(3,100);
			ps.executeUpdate();
			System.out.println("values inserted");
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Not connected " + e);
		}

	}

}
