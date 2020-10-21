package com.bit.day30;

import java.sql.SQLException;
import java.util.Properties;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// insert into
//		String url = "jdbc:oracle:thin:scott/tiger@127.0.0.1:1521:xe"; // driver 별로 주소의 규칙이 다르다.
//		Connection conn = DriverManager.getConnection
//		jdbc:oracle:<drivertype>:@<database>
//		("jdbc:oracle:thin:@myhost:1521:orcl", "scott", "tiger");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // driver 별로 주소의 규칙이 다르다.
		String sql = "insert into dept values (80, 'MARKETING', 'BEIJING')";
		
		oracle.jdbc.driver.OracleDriver driver = null;
		driver = new oracle.jdbc.driver.OracleDriver();
		
		java.sql.Connection conn = null;
		java.util.Properties prop = null;
		java.sql.Statement stmt = null;
		
		prop = new Properties();
		prop.setProperty("user", "scott");
		prop.setProperty("password", "tiger");
		
		try {
			conn = java.sql.DriverManager.getConnection(url, prop);
			System.out.println("It's connected : " + (conn != null));
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println("insert complete : " + (result == 1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
