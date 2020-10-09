package cn.edu.lingnan.test;

import java.sql.*;

public class MetaDataTest {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			prep=conn.prepareStatement("select * from student");
			rs=prep.executeQuery();
			DatabaseMetaData dmd=conn.getMetaData();
			System.out.println(dmd.getDatabaseProductName());
			System.out.println(dmd.getDriverName());
			System.out.println(dmd.getDriverVersion());
			ResultSetMetaData rmd=rs.getMetaData();
			System.out.println(rmd.getColumnCount());
			System.out.println(rmd.getColumnName(1));
			System.out.println(rmd.getColumnName(2));
			System.out.println(rmd.getColumnName(3));
			System.out.println(rmd.getColumnName(4));
			System.out.println(rmd.getColumnName(5));
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
