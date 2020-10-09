package cn.edu.lingnan.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;


import cn.edu.lingnan.dto.StudentDTO;
import cn.edu.lingnan.util.DataAccess;

public class StudentDAO {
	public boolean login(String _name,String _password){
		boolean flag=false;
		Connection conn=null;
		//Statement stmt=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			//----用到工具替代以上两句----
			conn=DataAccess.getConnection();
//			stmt=conn.createStatement();
//			rs=stmt.executeQuery("select * from student where sname= '"+_name+"' and password= '"+_password+"'");
			
			String sql="select * from student where state =1 and sname= ? and password= ? ";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _name);
			prep.setString(2, _password);
			rs=prep.executeQuery();
			
			if(rs.next())
				flag=true;
		} 
		catch (Exception e) {
			System.out.println("连接有问题！");
			e.printStackTrace();
		}
		finally {
//			try {
//				if(rs!=null)
//					rs.close();
//				if(prep!=null)
//					prep.close();
//				if(conn!=null)
//					conn.close();
//			} 
//			catch (Exception e) {
//				System.out.println("关闭有问题！");
//				e.printStackTrace();
//			}
			//---用工具代替优化上面几行代码-----
			DataAccess.closeConnection(rs, prep, conn);
		}
		return flag;
	}
	
	public StudentDTO newlogin(String _name,String _password){
		StudentDTO sd=new StudentDTO();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
			conn=DataAccess.getConnection();
			String sql="select * from student where state =1 and sname= ? and password= ? ";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _name);
			prep.setString(2, _password);
			rs=prep.executeQuery();
			
			if(rs.next()) {
				sd.setSid(rs.getString("sid"));
				sd.setSname(rs.getString("sname"));
				sd.setPassword(rs.getString("password"));
				sd.setSuperuser(rs.getInt("superuser"));
			}
		} 
		catch (Exception e) {
			System.out.println("连接有问题！");
			e.printStackTrace();
		}
		finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return sd;
	}
	
	public Vector<StudentDTO> findStuBySnameAndPasswordOut(String _sname,String _password) {
		Vector<StudentDTO> v=new Vector<StudentDTO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from student where state=1 and sname='"+_sname+"' and password='"+_password+"'");
			
			while(rs.next()) {
				StudentDTO s=new StudentDTO();
				s.setSid(rs.getString("sid"));
				s.setSname(rs.getString("sname"));
				s.setPassword(rs.getString("password"));
				s.setSuperuser(rs.getInt("superuser"));
				v.add(s);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
//			try {
//				if(rs!=null)
//					rs.close();
//				if(stmt!=null)
//					stmt.close();
//				if(conn!=null)
//					conn.close();
//			} 
//			catch (Exception e) {
//					e.printStackTrace();
//			}
			DataAccess.closeConnection(rs, stmt, conn);
		}
		return v;
	}
	
	public boolean findStuBySid(String _sid){
		boolean flag=false;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			//优化
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from student where state=1 and sid='"+_sid+"'");
			
			if(rs.next())
				flag=true;
		} 
		catch (Exception e) {
			System.out.println("连接有问题！");
			e.printStackTrace();
		}
		finally {
//			try {
//				if(rs!=null)
//					rs.close();
//				if(stmt!=null)
//					stmt.close();
//				if(conn!=null)
//					conn.close();
//			} 
//			catch (Exception e) {
//				System.out.println("关闭有问题！");
//				e.printStackTrace();
//			}
			DataAccess.closeConnection(rs, stmt, conn);
		}
		return flag;
	}
	
	public StudentDTO findStuduenBySidOut(String _sid) {
		StudentDTO s=new StudentDTO();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from student where state=1 and sid='"+_sid+"'");
			
			while(rs.next()) {
				s.setSid(rs.getString("sid"));
				s.setSname(rs.getString("sname"));
				s.setPassword(rs.getString("password"));
				s.setSuperuser(rs.getInt("superuser"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
//			try {
//				if(rs!=null)
//					rs.close();
//				if(stmt!=null)
//					stmt.close();
//				if(conn!=null)
//					conn.close();
//			} 
//			catch (Exception e) {
//					e.printStackTrace();
//			}
			DataAccess.closeConnection(rs, stmt, conn);
		}
		return s;
	}
	
	public Vector<StudentDTO> findStuBySidOut(String _sid) {
		Vector<StudentDTO> v=new Vector<StudentDTO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from student where state=1 and sid='"+_sid+"'");
			
			while(rs.next()) {
				StudentDTO s=new StudentDTO();
				s.setSid(rs.getString("sid"));
				s.setSname(rs.getString("sname"));
				s.setPassword(rs.getString("password"));
				s.setSuperuser(rs.getInt("superuser"));
				v.add(s);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
//			try {
//				if(rs!=null)
//					rs.close();
//				if(stmt!=null)
//					stmt.close();
//				if(conn!=null)
//					conn.close();
//			} 
//			catch (Exception e) {
//					e.printStackTrace();
//			}
			DataAccess.closeConnection(rs, stmt, conn);
		}
		return v;
	}
	
	public Vector<StudentDTO> searchStuBySidOut(String searchsname) {
		Vector<StudentDTO> v=new Vector<StudentDTO>();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
			String sql="select * from student where state=1 and sname like concat('%',?,'%')";
			conn=DataAccess.getConnection();
			prep=conn.prepareStatement(sql);
			prep.setString(1, searchsname);
			rs=prep.executeQuery();
			
			while(rs.next()) {
				StudentDTO s=new StudentDTO();
				s.setSid(rs.getString("sid"));
				s.setSname(rs.getString("sname"));
				s.setPassword(rs.getString("password"));
				s.setSuperuser(rs.getInt("superuser"));
				v.add(s);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
//			try {
//				if(rs!=null)
//					rs.close();
//				if(stmt!=null)
//					stmt.close();
//				if(conn!=null)
//					conn.close();
//			} 
//			catch (Exception e) {
//					e.printStackTrace();
//			}
			DataAccess.closeConnection(rs, prep, conn);
		}
		return v;
	}
	
	public Vector<StudentDTO> findAllStu() {
		Vector<StudentDTO> v=new Vector<StudentDTO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from student where state=1");
			
			while(rs.next()) {
				StudentDTO s=new StudentDTO();
				s.setSid(rs.getString("sid"));
				s.setSname(rs.getString("sname"));
				s.setPassword(rs.getString("password"));
				s.setSuperuser(rs.getInt("superuser"));
				v.add(s);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
//			try {
//				if(rs!=null)
//					rs.close();
//				if(stmt!=null)
//					stmt.close();
//				if(conn!=null)
//					conn.close();
//			} 
//			catch (Exception e) {
//					e.printStackTrace();
//			}
			DataAccess.closeConnection(rs, stmt, conn);
		}
		return v;
	}
	
	public Vector<StudentDTO> findDeletedStu() {
		Vector<StudentDTO> v=new Vector<StudentDTO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from student where state=0");
			
			while(rs.next()) {
				StudentDTO s=new StudentDTO();
				s.setSid(rs.getString("sid"));
				s.setSname(rs.getString("sname"));
				s.setPassword(rs.getString("password"));
				s.setSuperuser(rs.getInt("superuser"));
				v.add(s);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
//			try {
//				if(rs!=null)
//					rs.close();
//				if(stmt!=null)
//					stmt.close();
//				if(conn!=null)
//					conn.close();
//			} 
//			catch (Exception e) {
//					e.printStackTrace();
//			}
			DataAccess.closeConnection(rs, stmt, conn);
		}
		return v;
	}
	
	public boolean deleteStuBySid(String _sid){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		HashSet<String> h=new HashSet<String>();
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			
			//删除charactar的sid，再删student和team的信息
			//记录删除信息
			String sql="select * from charactar where state=1 and sid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _sid);
			rs1=prep.executeQuery();
			String str=null;
			while(rs1.next()) {
				//str=rs1.getString("tid");
				System.out.print(rs1.getString("tid")+":");
				sql="select count(*) as num from charactar where  state=1 and tid=?";
				prep=conn.prepareStatement(sql);
				prep.setString(1, str);
				rs2=prep.executeQuery();
				rs2.first();
				//System.out.println(rs2.getString("num"));
				if(Integer.parseInt(rs2.getString("num"))==1) {
					h.add(str);
				}
				prep.close();
			}
			
			//加上处理事务
			conn.setAutoCommit(false);
			//删除charactar的记录
			//sql="delete from charactar where sid=?";
			//软删除，删除操作改为修改标志位的操作
			sql="update charactar set state=0 where state=1 and sid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _sid);
			prep.executeUpdate();
			prep.close();
			
			//然后删除student的记录
			//sql="delete from student where sid=?";
			sql="update student set state=0 where state=1 and sid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _sid);
			prep.executeUpdate();
			prep.close();
			
			//删除team表的信息
			Iterator<String> it=h.iterator();
			while(it.hasNext()) {
				//sql="delete from team where tid=?";
				sql="update team set state=0 where state=1 and tid=?";
				prep=conn.prepareStatement(sql);
				prep.setString(1, it.next());
				prep.executeUpdate();
			}
			
			conn.commit();
			conn.setAutoCommit(true);
			
			flag=true;
		} 
		catch (Exception e) {
			System.out.println("连接有问题！");
			try {
				if(conn!=null)
					conn.rollback();//--撤销--
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
//			try {
//				if(rs2!=null)
//					rs2.close();
//				if(rs1!=null)
//					rs1.close();
//				if(prep!=null)
//					prep.close();
//				if(conn!=null)
//					conn.close();
//			} 
//			catch (Exception e) {
//				System.out.println("关闭有问题！");
//				e.printStackTrace();
//			}
			DataAccess.closeConnection(rs2, rs1, prep, conn);
		}
		return flag;
	}
	
	public boolean permanentdeleteStuBySid(String _sid){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		HashSet<String> h=new HashSet<String>();
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			
			//删除charactar的sid，再删student和team的信息
			//记录删除信息
			String sql="select * from charactar where state=1 and sid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _sid);
			rs1=prep.executeQuery();
			String str=null;
			while(rs1.next()) {
				//str=rs1.getString("tid");
				System.out.print(rs1.getString("tid")+":");
				sql="select count(*) as num from charactar where  state=1 and tid=?";
				prep=conn.prepareStatement(sql);
				prep.setString(1, str);
				rs2=prep.executeQuery();
				rs2.first();
				//System.out.println(rs2.getString("num"));
				if(Integer.parseInt(rs2.getString("num"))==1) {
					h.add(str);
				}
				prep.close();
			}
			
			//加上处理事务
			conn.setAutoCommit(false);
			//删除charactar的记录
			sql="delete from charactar where sid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _sid);
			prep.executeUpdate();
			prep.close();
			
			//然后删除student的记录
			sql="delete from student where sid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _sid);
			prep.executeUpdate();
			prep.close();
			
			//删除team表的信息
			Iterator<String> it=h.iterator();
			while(it.hasNext()) {
				sql="delete from team where tid=?";
				prep=conn.prepareStatement(sql);
				prep.setString(1, it.next());
				prep.executeUpdate();
			}
			
			conn.commit();
			conn.setAutoCommit(true);
			
			flag=true;
		} 
		catch (Exception e) {
			System.out.println("连接有问题！");
			try {
				if(conn!=null)
					conn.rollback();//--撤销--
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			DataAccess.closeConnection(rs2, rs1, prep, conn);
		}
		return flag;
	}

	public boolean returnDeteledStu(String _sid){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		conn=DataAccess.getConnection();
		
		try {
			String sql="update student set state=1 where sid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _sid);
			prep.executeUpdate();
			
			flag=true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	
	public boolean updateStu(StudentDTO _s){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		conn=DataAccess.getConnection();
		
		try {
			String sql="update student set sname=?, password=?, superuser=?, state=1 where sid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _s.getSname());
			prep.setString(2, _s.getPassword());
			prep.setInt(3, _s.getSuperuser());
			prep.setString(4, _s.getSid());
			prep.executeUpdate();
			
			flag=true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	
	public boolean insertStu(StudentDTO _s){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		conn=DataAccess.getConnection();
		
		try {
			String sql="insert into Student values(?,?,?,?,?)";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _s.getSid());
			prep.setString(2, _s.getSname());
			prep.setString(3, _s.getPassword());
			prep.setInt(4, _s.getSuperuser());
			prep.setInt(5, 1);
			prep.executeUpdate();
			
			flag=true;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	
}














