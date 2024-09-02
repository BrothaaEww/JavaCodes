package com.demo.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex_14 {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:mysql://localhost:3306/CallableTesting";
			con = DriverManager.getConnection(url, "root", "7980784725");
			System.out.println("connected");
			cs = con.prepareCall("{call demo3(?,?,?)}");
			cs.setInt(1, 2);
			cs.registerOutParameter(2, java.sql.Types.INTEGER);
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);

			rs = cs.executeQuery();
			
			while (rs.next()) {
				System.out.println("Name : " + rs.getString(3));
//				System.out.println("ID : " + rs.getInt(2));

			}
//			System.out.println(cs.getString(3));
			System.out.println("COUNT : " + cs.getInt(2));
		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
		}
		finally{
//			rs.close();
			cs.close();
			con.close();
		}

	}

}
