package cn.edu.lingnan.test;

import java.util.Vector;

import cn.edu.lingnan.dao.StudentDAO;
import cn.edu.lingnan.dto.StudentDTO;

public class StudentTest {

	public static void main(String[] args) {
		StudentDAO sd=new StudentDAO();
//		System.out.println(sd.login("zhangsan", "zhangsan"));
//		System.out.println(sd.login("qianqi", "qianqi"));
//		System.out.println(sd.findStuBySid("s01"));
//		System.out.println(sd.findStuBySid("s11"));
		
		Vector<StudentDTO> v=new Vector<StudentDTO>();
//		v=sd.findAllStu();
//		for(StudentDTO s:v) {
//			System.out.println(s.getSid()+"  "+s.getSname()+"  "+s.getPassword()+"  "+s.getSuperuser());
//		}
		
//		v=sd.findDeletedStu();
//		for(StudentDTO s:v) {
//			System.out.println(s.getSid()+"  "+s.getSname()+"  "+s.getPassword()+"  "+s.getSuperuser());
//		}
		
//		sd.deleteStuBySid("s05");
		StudentDTO s=new StudentDTO();
		s.setSid("s06");
		s.setSname("bbb");
		s.setPassword("bbb");
		s.setSuperuser(1);
		if(sd.updateStu(s)) {
			System.out.println("修改成功！");
		}
		else {
			System.out.println("修改失败！");
		}
		
//		s.setSid("s05");
//		s.setSname("qianqi");
//		s.setPassword("qianqi");
//		s.setSuperuser(3);
//		if(sd.insertStu(s)){
//			System.out.println("插入成功！");
//		}
//		else {
//			System.out.println("插入失败！");
//		}
		
	}

}
