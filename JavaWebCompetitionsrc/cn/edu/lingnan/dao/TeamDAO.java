package cn.edu.lingnan.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.TeamDTO;
import cn.edu.lingnan.util.DataAccess;

public class TeamDAO {
	public boolean findTeamByTid(String _tid){
		boolean flag=false;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from team where state=1 and tid='"+_tid+"'");
			
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
	
	public Vector<TeamDTO> findTeamByTidOut(String _tid){
		Vector<TeamDTO> v=new Vector<TeamDTO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from team where state=1 and tid='"+_tid+"'");
			
			while(rs.next()) {
				TeamDTO t=new TeamDTO();
				t.setTid(rs.getString("tid"));
				t.setTname(rs.getString("tname"));
				v.add(t);
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
	
	public Vector<TeamDTO> findAllTeam(){
		Vector<TeamDTO> v=new Vector<TeamDTO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from team where state=1");
			
			while(rs.next()) {
				TeamDTO t=new TeamDTO();
				t.setTid(rs.getString("tid"));
				t.setTname(rs.getString("tname"));
				v.add(t);
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
	
	public Vector<TeamDTO> findDeteledTeam(){
		Vector<TeamDTO> v=new Vector<TeamDTO>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from team where state=0");
			
			while(rs.next()) {
				TeamDTO t=new TeamDTO();
				t.setTid(rs.getString("tid"));
				t.setTname(rs.getString("tname"));
				v.add(t);
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
	
	public boolean deleteTeamByTid(String _tid){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			//事务处理
			conn.setAutoCommit(false);
			
			//删除charactar的信息
			//String sql="delete from charactar where tid=?";
			String sql="update charactar set state=0 where state=1 and tid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _tid);
			prep.executeUpdate();
			prep.close();
			
			//删除team的信息
			//sql="delete from team where tid=?";
			sql="update team set state=0 where state=1 and tid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _tid);
			prep.executeUpdate();
			
			conn.commit();
			conn.setAutoCommit(true);
			flag=true;
		} 
		catch (Exception e) {
			System.out.println("连接有问题！");
			try {
				if(conn!=null)
					conn.rollback();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
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
	
	public boolean permanentdeleteTeamByTid(String _tid){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "root");
			conn=DataAccess.getConnection();
			//事务处理
			conn.setAutoCommit(false);
			
			//删除charactar的信息
			String sql="delete from charactar where tid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _tid);
			prep.executeUpdate();
			prep.close();
			
			//删除team的信息
			sql="delete from team where tid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _tid);
			prep.executeUpdate();
			
			conn.commit();
			conn.setAutoCommit(true);
			flag=true;
		} 
		catch (Exception e) {
			System.out.println("连接有问题！");
			try {
				if(conn!=null)
					conn.rollback();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
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
	
	public boolean returnDeteledTeam(String _tid) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		conn=DataAccess.getConnection();
		
		try {
			String sql="update team set state=1 where tid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _tid);
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
	
	public boolean updataTeam(TeamDTO _t) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		conn=DataAccess.getConnection();
		
		try {
			String sql="update team set tname=?, state=1 where tid=?";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _t.getTname());
			prep.setString(2, _t.getTid());
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
	
	public boolean insertTeam(TeamDTO _t){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		conn=DataAccess.getConnection();
		
		try {
			String sql="insert into team values(?,?,?)";
			prep=conn.prepareStatement(sql);
			prep.setString(1, _t.getTid());
			prep.setString(2, _t.getTname());
			prep.setInt(3, 1);
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














