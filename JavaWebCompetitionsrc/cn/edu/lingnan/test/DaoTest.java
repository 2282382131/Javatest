package cn.edu.lingnan.test;

import java.util.Scanner;

//import cn.edu.lingnan.dao.CharactarDAO;
//import cn.edu.lingnan.dao.StudentDAO;
//import cn.edu.lingnan.dao.TeamDAO;
//import cn.edu.lingnan.dto.CharactarDTO;
//import cn.edu.lingnan.dto.StudentDTO;
//import cn.edu.lingnan.dto.TeamDTO;
//import cn.edu.lingnan.menu.Add;
//import cn.edu.lingnan.menu.Detele;
import cn.edu.lingnan.menu.Menu;
//import cn.edu.lingnan.menu.Modify;
//import cn.edu.lingnan.menu.Query;
import cn.edu.lingnan.util.SysOutAccess;

public class DaoTest {
	
	public static Scanner scanf=new Scanner(System.in);
//	public static StudentDAO sd=new StudentDAO();
//	public static StudentDTO s=new StudentDTO();
//	public static TeamDAO te=new TeamDAO();
//	public static TeamDTO t=new TeamDTO();
//	public static CharactarDAO ch=new CharactarDAO();
//	public static CharactarDTO c=new CharactarDTO();

	public static void main(String[] args) {
		System.out.println("-----------��ӭ���������Ŷӹ���ϵͳ-----------");
//		System.out.println("--1����ѯ��Ϣ��2��������Ϣ��3���޸���Ϣ��4��ɾ����Ϣ��5���˳�ϵͳ--");
		SysOutAccess.menuOne();
		while(scanf.hasNextLine()) {
			String str=scanf.nextLine();
			switch(str) {
				case "1" :Menu.query();break;
				case "2" :Menu.add();break;
				case "3" :Menu.modify();break;
				case "4" :Menu.delete();break;
				case "5" :Menu.end();break;
			}
		}
	}
	//һ���˵�
	
	//�����˵�
	
}











