package com.demo.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Ex_13 {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:mysql://localhost:3306/CallableTesting";
			con = DriverManager.getConnection(url, "root", "7980784725");
			System.out.println("connected");
			cs = con.prepareCall("{call demo2(3)}");
			rs = cs.executeQuery();
			while(rs.next()) {
				System.out.println("Name : "+rs.getString("name"));
			}
			
			
		} catch (Exception e) {
			System.out.println("Not connected " + e);
		}

	}

}
