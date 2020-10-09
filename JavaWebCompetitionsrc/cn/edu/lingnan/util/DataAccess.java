package cn.edu.lingnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class DataAccess {
	
	public static String driver=null;
	public static String url=null;
	public static String user=null;
	public static String password=null;
	public static String xmlPath="database.conf.xml";
	public static String xsdPath="database.conf.xsd";
	
	static {
		String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		xmlPath=basePath+xmlPath;
		xsdPath=basePath+xsdPath;
	}
	
	//��ȡ���ݿ�����ӷ���
	public static Connection getConnection() {
		Connection conn=null;
		
		if(XmlValitor.validate(xsdPath, xmlPath)) {
			HashMap<String,String> hm=XmlParser.parser(xmlPath);
			driver=hm.get("driver");
			url=hm.get("url");
			user=hm.get("user");
			password=hm.get("password");
		}
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		} 
		catch (Exception e) {
			System.out.println("���ӳ������ˣ�");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeConnection(ResultSet rs,PreparedStatement prep,Connection conn) {
		try {
			if(rs!=null)
				rs.close();
			if(prep!=null)
				prep.close();
			if(conn!=null)
				conn.close();
		} 
		catch (Exception e) {
			System.out.println("�ر������⣡");
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(ResultSet rs,Statement stmt,Connection conn) {
		try {
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
		} 
		catch (Exception e) {
			System.out.println("�ر������⣡");
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(ResultSet rs2,ResultSet rs1,PreparedStatement prep,Connection conn) {
		try {
			if(rs2!=null)
				rs2.close();
			if(rs1!=null)
				rs1.close();
			if(prep!=null)
				prep.close();
			if(conn!=null)
				conn.close();
		} 
		catch (Exception e) {
			System.out.println("�ر������⣡");
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(PreparedStatement prep,Connection conn) {
		try {
			if(prep!=null)
				prep.close();
			if(conn!=null)
				conn.close();
		} 
		catch (Exception e) {
			System.out.println("�ر������⣡");
			e.printStackTrace();
		}
	}
	
}
