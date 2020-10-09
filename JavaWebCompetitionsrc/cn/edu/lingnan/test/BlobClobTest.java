package cn.edu.lingnan.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.edu.lingnan.util.DataAccess;

public class BlobClobTest {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
//			//---------��bolb-----------------
//			prep=conn.prepareStatement("insert into blobtable values(?,?)");
//			prep.setInt(1, 1);
//			File f=new File("C:\\Users\\�����\\Pictures\\Camera Roll\\õ��.jpg");
//			FileInputStream fis=new FileInputStream(f);
//			prep.setBinaryStream(2, fis, (int)f.length());
//			prep.executeUpdate();
//			prep.close();
//			//---------ȡbolb-----------------
//			prep=conn.prepareStatement("select * from blobtable");
//			rs=prep.executeQuery();
//			rs.next();
//			InputStream is=rs.getBinaryStream("pic");
//			File fh=new File("C:\\Users\\�����\\Pictures\\Camera Roll\\õ��1.jpg");
//			FileOutputStream fos=new FileOutputStream(fh);
//			int i=0;
//			while((i=is.read())!=-1) {
//				fos.write(i);
//			}
//			fos.close();
			
//			//---------��clob-----------------
			prep=conn.prepareStatement("insert into clobtable values(?,?)");
			prep.setInt(1, 1);
			File f=new File("C:\\Users\\�����\\Pictures\\Camera Roll\\blob-clob.txt");
			FileInputStream fis=new FileInputStream(f);
			prep.setAsciiStream(2, fis, (int)f.length());
			prep.executeUpdate();
			prep.close();
			//---------ȡclob-----------------
//			prep=conn.prepareStatement("select * from clobtable");
//			rs=prep.executeQuery();
//			rs.next();
//			InputStream is=rs.getAsciiStream("txt");
//			File f=new File("C:\\Users\\�����\\Pictures\\Camera Roll\\blob-clob1.txt");
//			FileOutputStream fos=new FileOutputStream(f);
//			int i=0;
//			while((i=is.read())!=-1) {
//				fos.write(i);
//			}
//			fos.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DataAccess.closeConnection(rs, prep, conn);
		}
		
		
	}

}
