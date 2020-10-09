package cn.edu.lingnan.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBATest {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
//			String sql="insert into student values(?,?)";
//			prep=conn.prepareStatement(sql);
			//---预处理---
//			prep.setString(1, "qianqi");
//			prep.setInt(2, 70);
//			prep.executeUpdate();
			//---批处理---
//			prep.setString(1,"aaa");
//			prep.setInt(2, 11);
//			prep.addBatch();
//			prep.setString(1,"bbb");
//			prep.setInt(2, 22);
//			prep.addBatch();
//			prep.setString(1,"ccc");
//			prep.setInt(2, 33);
//			prep.addBatch();
//			int[] a=prep.executeBatch();
//			for(int b:a) {
//				System.out.println(b);
//			}
		//---通过更新结果集来个信数据库----	
			String sql="select * from student";
			prep=conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=prep.executeQuery();
			//--指针移动操作--
//			System.out.println(rs.isBeforeFirst());
//			System.out.println(rs.isFirst());
//			rs.absolute(4);
//			System.out.println(rs.getString("name"));
//			rs.relative(-3);
//			System.out.println(rs.getString("name"));
//			rs.last();
//			System.out.println(rs.getString("name"));
			
			//--更新操作--
//			rs.absolute(4);
//			rs.updateString("name", "dabc");
//			rs.updateRow();
			
			//--删除操作--
			rs.absolute(4);
			rs.deleteRow();
			
			//插入操作
//			String sql="select * from student";
//			prep=conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			rs=prep.executeQuery();
//			rs.moveToInsertRow();//移动中插入的行，其实就是一个空行
//			rs.updateString("name", "ddd");//更新字段
//			rs.updateInt("age", 44);
//			rs.insertRow();//执行插入
			
		} 
		catch (Exception e) {
			System.out.println("连接有问题！");
			e.printStackTrace();
		}
		finally {
			try {
				if(prep!=null)
					prep.close();
				if(conn!=null)
					conn.close();
			} 
			catch (Exception e) {
				System.out.println("关闭有问题！");
				e.printStackTrace();
			}
		}

	}

}
