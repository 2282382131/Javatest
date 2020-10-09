package cn.edu.lingnan.menu;

import java.util.Scanner;

import cn.edu.lingnan.dao.CharactarDAO;
import cn.edu.lingnan.dao.StudentDAO;
import cn.edu.lingnan.dao.TeamDAO;
import cn.edu.lingnan.dto.CharactarDTO;
import cn.edu.lingnan.dto.StudentDTO;
import cn.edu.lingnan.dto.TeamDTO;
import cn.edu.lingnan.util.SysOutAccess;

public class Modify {
	
	public static Scanner scanf=new Scanner(System.in);
	public static StudentDAO sd=new StudentDAO();
	public static StudentDTO s=new StudentDTO();
	public static TeamDAO te=new TeamDAO();
	public static TeamDTO t=new TeamDTO();
	public static CharactarDAO ch=new CharactarDAO();
	public static CharactarDTO c=new CharactarDTO();
	
	public static void modifyStu(){
		SysOutAccess.modifyStu();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1" :{
					System.out.println("������Ҫ���µ�sid��");
					String sid=scanf.nextLine();
					System.out.println("��������µ�sname��");
					String sname=scanf.nextLine();
					System.out.println("��������µ�password��");
					String password=scanf.nextLine();
					System.out.println("��������µ�superuser��");
					int superuser=scanf.nextInt();
					s.setSid(sid);
					s.setSname(sname);
					s.setPassword(password);
					s.setSuperuser(superuser);
					if(sd.findStuBySid(sid)) {
						sd.updateStu(s);
						System.out.println("�޸ĳɹ���");
						SysOutAccess.continueIn();
						SysOutAccess.modifyStu();
					}
					else {
						System.out.println("û�ҵ���sid��");
						System.out.println("�޸�ʧ�ܣ�");
						SysOutAccess.continueIn();
						SysOutAccess.modifyStu();
					}
					break;
				}
				case "2" :{
					flag=false;
					SysOutAccess.menuModify();
					break;
				}
				case "3" :{
					end();
					break;
				}
			}
		}
	}
	
	public static void modifyTeam(){
		SysOutAccess.modifyTeam();	
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1" :{
					System.out.println("������Ҫ���µ�tid��");
					String tid=scanf.nextLine();
					System.out.println("��������µ�tname��");
					String tname=scanf.nextLine();
					t.setTid(tid);
					t.setTname(tname);
					if(te.findTeamByTid(tid)) {
						te.updataTeam(t);
						System.out.println("�޸ĳɹ���");
						SysOutAccess.continueIn();
						SysOutAccess.modifyStu();
					}
					else {
						System.out.println("û�ҵ���tid��");
						System.out.println("�޸�ʧ�ܣ�");
						SysOutAccess.continueIn();
						SysOutAccess.modifyStu();
					}
					break;
				}
				case "2" :{
					flag=false;
					SysOutAccess.menuModify();
					break;
				}
				case "3" :{
					end();
					break;
				}
			}
		}
	}

	public static void modifyCharactar(){
		SysOutAccess.modifyCharactar();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1" :{
					System.out.println("������Ҫ���µ�sid��");
					String sid=scanf.nextLine();
					System.out.println("������Ҫ���µ�tid��");
					String tid=scanf.nextLine();
					System.out.println("��������µ�role��");
					String role=scanf.nextLine();
					c.setSid(sid);
					c.setTid(tid);
					c.setRole(role);
					if(ch.findCharactarBySidATid(sid, tid)) {
						ch.updataCharactar(c);
						System.out.println("���³ɹ���");
						SysOutAccess.continueIn();
						SysOutAccess.modifyStu();
					}
					else {
						System.out.println("û�ҵ���sid��tid��");
						System.out.println("����ʧ�ܣ�");
						SysOutAccess.continueIn();
						SysOutAccess.modifyStu();
					}
					break;
				}
				case "2" :{
					flag=false;
					SysOutAccess.menuModify();
					break;
				}
				case "3" :{
					end();
					break;
				}
			}
		}
	}
	
	public static void end() {
		System.out.println("��лʹ�ã�ϵͳ���˳�������");
		System.exit(0);
	}
	
}
