package cn.edu.lingnan.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.CharactarDTO;
import cn.edu.lingnan.util.DataAccess;

public class CharactarDAO {
	public boolean findCharactarBySidATid(String _sid,String _tid){
		boolean flag=false;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from charactar where state=1 and sid= '"+_sid+"' and tid= '"+_tid+"'");
			
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
	
	public Vector<CharactarDTO> findCharactarBySidATidOut(String _sid,String _tid){
		Vector<CharactarDTO> v=new Vector<CharactarDTO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from charactar where state=1 and sid='"+_sid+"' and tid='"+_tid+"'");
			
			while(rs.next()) {
				CharactarDTO c=new CharactarDTO();
				c.setSid(rs.getString("sid"));
				c.setTid(rs.getString("tid"));
				c.setRole(rs.getString("role"));
				v.add(c);
			}
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
		return v;
	}
	
	public Vector<CharactarDTO> findGroupCharactar(String _tid){
		Vector<CharactarDTO> v=new Vector<CharactarDTO>();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			String sql="select * from charactar where state=1 and tid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _tid);
			rs=prep.executeQuery();
			
			while(rs.next()) {
				CharactarDTO c=new CharactarDTO();
				c.setSid(rs.getString("sid"));
				c.setTid(rs.getString("tid"));
				c.setRole(rs.getString("role"));
				v.add(c);
			}
		} 
		catch (Exception e) {
			System.out.println("连接有问题！");
			e.printStackTrace();
		}
		finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return v;
	}
	
	public int findGroupCharactarNum(String _tid){
		int num=0;
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			String sql="select count(*) as num from charactar where state=1 and tid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _tid);
			rs=prep.executeQuery();
			
			if(rs.next()) {
				num=Integer.parseInt(rs.getString("num"));
			}
		} 
		catch (Exception e) {
			System.out.println("连接有问题！");
			e.printStackTrace();
		}
		finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		return num;
	}
	
	public Vector<CharactarDTO> findAllCharactar(){
		Vector<CharactarDTO> v=new Vector<CharactarDTO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from charactar where state=1");
			
			while(rs.next()) {
				CharactarDTO c=new CharactarDTO();
				c.setSid(rs.getString("sid"));
				c.setTid(rs.getString("tid"));
				c.setRole(rs.getString("role"));
				v.add(c);
			}
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
		return v;
	}
	
	public Vector<CharactarDTO> findCharactarBySid(String _sid){
		Vector<CharactarDTO> v=new Vector<CharactarDTO>();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			String sql="select * from charactar where state=1 and sid=?";
			conn=DataAccess.getConnection();
			prep=conn.prepareStatement(sql);
			prep.setString(1, _sid);
			rs=prep.executeQuery();
			
			while(rs.next()) {
				CharactarDTO c=new CharactarDTO();
				c.setSid(rs.getString("sid"));
				c.setTid(rs.getString("tid"));
				c.setRole(rs.getString("role"));
				v.add(c);
			}
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
			DataAccess.closeConnection(rs, prep, conn);
		}
		return v;
	}
	
	public Vector<CharactarDTO> findApplyCharactar(){
		Vector<CharactarDTO> v=new Vector<CharactarDTO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from charactar where state=2");
			
			while(rs.next()) {
				CharactarDTO c=new CharactarDTO();
				c.setSid(rs.getString("sid"));
				c.setTid(rs.getString("tid"));
				c.setRole(rs.getString("role"));
				v.add(c);
			}
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
		return v;
	}
	
	public Vector<CharactarDTO> findexitCharactar(){
		Vector<CharactarDTO> v=new Vector<CharactarDTO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from charactar where state=3");
			
			while(rs.next()) {
				CharactarDTO c=new CharactarDTO();
				c.setSid(rs.getString("sid"));
				c.setTid(rs.getString("tid"));
				c.setRole(rs.getString("role"));
				v.add(c);
			}
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
		return v;
	}
	
	public Vector<CharactarDTO> findDeteledCharactar(){
		Vector<CharactarDTO> v=new Vector<CharactarDTO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from charactar where state=0");
			
			while(rs.next()) {
				CharactarDTO c=new CharactarDTO();
				c.setSid(rs.getString("sid"));
				c.setTid(rs.getString("tid"));
				c.setRole(rs.getString("role"));
				v.add(c);
			}
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
		return v;
	}
	
	public boolean deleteCharactarBySidAndTid(String _sid,String _tid){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			//String sql="delete from charactar where sid=? and tid=?";
			String sql="update charactar set state=0 where state=1 and sid=? and tid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _sid);
			prep.setString(2, _tid);
			prep.executeUpdate();
			
			flag=true;
		} 
		catch (Exception e) {
			System.out.println("连接有问题！");
			e.printStackTrace();
		}
		finally {
//			try {
//				if(prep!=null)
//					prep.close();
//				if(conn!=null)
//					conn.close();
//			} 
//			catch (Exception e) {
//				System.out.println("关闭有问题！");
//				e.printStackTrace();
//			}
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	
	public boolean deleteExitCharactarBySidAndTid(String _sid,String _tid){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			//String sql="delete from charactar where sid=? and tid=?";
			String sql="update charactar set state=0 where state=3 and sid=? and tid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _sid);
			prep.setString(2, _tid);
			prep.executeUpdate();
			
			flag=true;
		} 
		catch (Exception e) {
			System.out.println("连接有问题！");
			e.printStackTrace();
		}
		finally {
//			try {
//				if(prep!=null)
//					prep.close();
//				if(conn!=null)
//					conn.close();
//			} 
//			catch (Exception e) {
//				System.out.println("关闭有问题！");
//				e.printStackTrace();
//			}
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	
	public boolean permanentdeleteCharactarBySidAndTid(String _sid,String _tid){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			String sql="delete from charactar where sid=? and tid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _sid);
			prep.setString(2, _tid);
			prep.executeUpdate();
			
			flag=true;
		} 
		catch (Exception e) {
			System.out.println("连接有问题！");
			e.printStackTrace();
		}
		finally {
//			try {
//				if(prep!=null)
//					prep.close();
//				if(conn!=null)
//					conn.close();
//			} 
//			catch (Exception e) {
//				System.out.println("关闭有问题！");
//				e.printStackTrace();
//			}
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	
	public boolean returnDeteledCharactar(String _sid,String _tid){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		conn=DataAccess.getConnection();
		
		try {
			String sql="update charactar set state=1 where sid=? and tid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _sid);
			prep.setString(2, _tid);
			prep.executeUpdate();
			
			flag=true;
		} 
		catch (SQLException e) {
			System.out.println("连接出问题！");
			e.printStackTrace();
		}
		finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	
	public boolean updataCharactar(CharactarDTO _c){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		conn=DataAccess.getConnection();
		
		try {
			String sql="update charactar set role=?, state=1 where sid=? and tid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _c.getRole());
			prep.setString(2, _c.getSid());
			prep.setString(3, _c.getTid());
			prep.executeUpdate();
			
			flag=true;
		} 
		catch (SQLException e) {
			System.out.println("连接出问题！");
			e.printStackTrace();
		}
		finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	
	public boolean updataApplyCharactar(CharactarDTO _c){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		conn=DataAccess.getConnection();
		
		try {
			String sql="update charactar set state=1 where sid=? and tid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _c.getSid());
			prep.setString(2, _c.getTid());
			prep.executeUpdate();
			
			flag=true;
		} 
		catch (SQLException e) {
			System.out.println("连接出问题！");
			e.printStackTrace();
		}
		finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	
	public boolean updataExitCharactar(String _sid,String _tid){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		conn=DataAccess.getConnection();
		
		try {
			String sql="update charactar set state=3 where sid=? and tid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _sid);
			prep.setString(2, _tid);
			prep.executeUpdate();
			
			flag=true;
		} 
		catch (SQLException e) {
			System.out.println("连接出问题！");
			e.printStackTrace();
		}
		finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	

	public boolean insertCharactar(CharactarDTO _c){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		conn=DataAccess.getConnection();
		
		try {
			String sql="insert into charactar values(?,?,?,?)";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _c.getSid());
			prep.setString(2, _c.getTid());
			prep.setString(3, _c.getRole());
			prep.setInt(4, 1);
			prep.executeUpdate();
			
			flag=true;
		} 
		catch (SQLException e) {
			System.out.println("连接出问题！");
			e.printStackTrace();
		}
		finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	
	public boolean applyCharactar(CharactarDTO _c){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		conn=DataAccess.getConnection();
		
		try {
			String sql="insert into charactar values(?,?,?,?)";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _c.getSid());
			prep.setString(2, _c.getTid());
			prep.setString(3, _c.getRole());
			prep.setInt(4, 2);
			prep.executeUpdate();
			
			flag=true;
		} 
		catch (SQLException e) {
			System.out.println("连接出问题！");
			e.printStackTrace();
		}
		finally {
			DataAccess.closeConnection(prep, conn);
		}
		return flag;
	}
	
}














