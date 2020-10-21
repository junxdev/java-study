package com.bit.day30;

public class Ex02 {
	
	public static void main(String[] args) {
		String sql = "select * from dept order by deptno";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		java.util.Properties prop = new java.util.Properties();
		prop.setProperty("user", "scott");
		prop.setProperty("password", "tiger");
		
		java.sql.Connection conn = null;
		java.sql.Statement stmt = null;
		java.sql.ResultSet rs = null;
		
//		oracle.jdbc.driver.OracleDriver driver = null;
//		driver = new oracle.jdbc.driver.OracleDriver();
		new oracle.jdbc.driver.OracleDriver(); // DriverManager가 앞서 불러온 DB driver를 인식
		
		try {
			conn = java.sql.DriverManager.getConnection(url, prop);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getObject(1) + "\t");
				System.out.print(rs.getObject(2) + "\t");
				System.out.print(rs.getObject(3));
				System.out.println();
			}
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (java.sql.SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
