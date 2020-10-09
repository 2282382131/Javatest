package cn.edu.lingnan.menu;

import java.util.Scanner;

import cn.edu.lingnan.dao.CharactarDAO;
import cn.edu.lingnan.dao.StudentDAO;
import cn.edu.lingnan.dao.TeamDAO;
import cn.edu.lingnan.dto.CharactarDTO;
import cn.edu.lingnan.dto.StudentDTO;
import cn.edu.lingnan.dto.TeamDTO;
import cn.edu.lingnan.util.SysOutAccess;

public class Add {
	
	public static Scanner scanf=new Scanner(System.in);
	public static StudentDAO sd=new StudentDAO();
	public static StudentDTO s=new StudentDTO();
	public static TeamDAO te=new TeamDAO();
	public static TeamDTO t=new TeamDTO();
	public static CharactarDAO ch=new CharactarDAO();
	public static CharactarDTO c=new CharactarDTO();
	
	public static void addStu(){
		SysOutAccess.addStu();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1":{
					System.out.println("请输入sid：");
					String sid=scanf.nextLine();
					System.out.println("请输入sname：");
					String sname=scanf.nextLine();
					System.out.println("请输入password：");
					String password=scanf.nextLine();
					System.out.println("请输入superuser：");
					int superuser=scanf.nextInt();
					s.setSid(sid);
					s.setSname(sname);
					s.setPassword(password);
					s.setSuperuser(superuser);
					if(!sd.findStuBySid(sid)){
						sd.insertStu(s);
						System.out.println("插入成功！");
						SysOutAccess.continueIn();
						SysOutAccess.addStu();
					}
					else {
						System.out.println("该sid已存在！");
						System.out.println("插入失败！");
						SysOutAccess.continueIn();
						SysOutAccess.addStu();
					}
					break;
				}
				case "2":{
					flag=false;
					SysOutAccess.menuAdd();
					break;
				}
				case "3":{
					end();
					break;
				}
			}
		}
	}
	
	public static void addTeam(){
		SysOutAccess.addTeam();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1":{
					System.out.println("请输入tid：");
					String tid=scanf.nextLine();
					System.out.println("请输入tname：");
					String tname=scanf.nextLine();
					t.setTid(tid);
					t.setTname(tname);
					if(!te.findTeamByTid(tid)) {
						te.insertTeam(t);
						System.out.println("插入成功！");
						SysOutAccess.continueIn();
						SysOutAccess.addStu();
					}
					else {
						System.out.println("该tid已存在！");
						System.out.println("插入失败！");
						SysOutAccess.continueIn();
						SysOutAccess.addStu();
					}
					break;
				}
				case "2":{
					flag=false;
					SysOutAccess.menuAdd();
					break;
				}
				case "3":{
					end();
					break;
				}
			}
		}
	}
	
	public static void addCharactar(){
		SysOutAccess.addCharactar();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1":{
					System.out.println("请输入sid：");
					String sid=scanf.nextLine();
					System.out.println("请输入tid：");
					String tid=scanf.nextLine();
					System.out.println("请输入role：");
					String role=scanf.nextLine();
					c.setSid(sid);
					c.setTid(tid);
					c.setRole(role);
					if(ch.findCharactarBySidATid(sid, tid)) {
						ch.insertCharactar(c);
						System.out.println("插入成功！");
						SysOutAccess.continueIn();
						SysOutAccess.addStu();
					}
					else {
						System.out.println("该sid和tid已存在！");
						System.out.println("插入失败！");
						SysOutAccess.continueIn();
						SysOutAccess.addStu();
					}
					break;
				}
				case "2":{
					flag=false;
					SysOutAccess.menuAdd();
					break;
				}
				case "3":{
					end();
					break;
				}
			}
		}
	}
	
	public static void end() {
		System.out.println("感谢使用，系统已退出！！！");
		System.exit(0);
	}
	
	
}
