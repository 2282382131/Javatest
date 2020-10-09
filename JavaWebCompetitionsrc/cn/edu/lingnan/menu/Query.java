package cn.edu.lingnan.menu;

import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.dao.CharactarDAO;
import cn.edu.lingnan.dao.StudentDAO;
import cn.edu.lingnan.dao.TeamDAO;
import cn.edu.lingnan.dto.CharactarDTO;
import cn.edu.lingnan.dto.StudentDTO;
import cn.edu.lingnan.dto.TeamDTO;
import cn.edu.lingnan.util.SysOutAccess;

public class Query {
	
	public static Scanner scanf=new Scanner(System.in);
	public static StudentDAO sd=new StudentDAO();
	public static StudentDTO s=new StudentDTO();
	public static TeamDAO te=new TeamDAO();
	public static TeamDTO t=new TeamDTO();
	public static CharactarDAO ch=new CharactarDAO();
	public static CharactarDTO c=new CharactarDTO();
	
	public static void findStu(){
		Vector<StudentDTO> v=new Vector<StudentDTO>();
//		System.out.println("--1、查询按sname和password；2、查询按sid；3、查询所有student；4、返回上一级；5、退出系统--");
		SysOutAccess.queryStu();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1" :{
					System.out.println("请输入要查找的sname：");
					String sname=scanf.nextLine();
					System.out.println("请输入要查找的password：");
					String password=scanf.nextLine();
					if(sd.login(sname, password)) {
						SysOutAccess.asterisk();
						SysOutAccess.stuTopName();
						v=sd.findStuBySnameAndPasswordOut(sname, password);
						for(StudentDTO s:v) {
							System.out.println(s.getSid()+"  "+s.getSname()+"  "+s.getPassword()+"  "+s.getSuperuser());
						}
						SysOutAccess.asterisk();
						SysOutAccess.continueIn();
						SysOutAccess.queryStu();
					}
					else {
						SysOutAccess.queryNo();
						SysOutAccess.queryStu();
					}
					break;
				}
				case "2" :{
					System.out.println("请输入要查找的sid号：");
					String sid=scanf.nextLine();
					if(sd.findStuBySid(sid)) {
						SysOutAccess.asterisk();
						SysOutAccess.stuTopName();
						v=sd.findStuBySidOut(sid);
						for(StudentDTO s:v) {
							System.out.println(s.getSid()+"  "+s.getSname()+"  "+s.getPassword()+"  "+s.getSuperuser());
						}
						SysOutAccess.asterisk();
						SysOutAccess.continueIn();
						SysOutAccess.queryStu();
					}
					else {
						SysOutAccess.queryNo();
						SysOutAccess.queryStu();
					}
					break;
				}
				case "3" :{
					v=sd.findAllStu();
					System.out.println("查询成功，结果如下！");
					SysOutAccess.asterisk();
					SysOutAccess.stuTopName();
					for(StudentDTO s:v) {
						System.out.println(s.getSid()+"  "+s.getSname()+"  "+s.getPassword()+"  "+s.getSuperuser());
					}
					SysOutAccess.asterisk();
					SysOutAccess.continueIn();
					SysOutAccess.queryStu();
					break;
					}
				case "4" :{
					flag=false;
//					System.out.println("--1、查询student信息；2、查询team信息；3、查询charactar信息；4、返回上一级；5、退出系统--");
					SysOutAccess.menuQuery();
					break;
				}
				case "5" :end();break;
			}
		}
	}
	
	public static void findTeam(){
		Vector<TeamDTO> v=new Vector<TeamDTO>();
		SysOutAccess.queryTeam();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1" :{
					System.out.println("请输入要查找的tid：");
					String tid=scanf.nextLine();
					if(te.findTeamByTid(tid)) {
						SysOutAccess.asterisk();
						SysOutAccess.teamTopName();
						v=te.findTeamByTidOut(tid);
						for(TeamDTO t:v) {
							System.out.println(t.getTid()+"  "+t.getTname());
						}
						SysOutAccess.asterisk();
						SysOutAccess.continueIn();
						SysOutAccess.queryTeam();
					}
					else {
						SysOutAccess.queryNo();
						SysOutAccess.queryTeam();
					}
					break;
				}
				case "2" :{
					v=te.findAllTeam();
					System.out.println("查询成功，结果如下！");
					SysOutAccess.asterisk();
					SysOutAccess.teamTopName();
					for(TeamDTO t:v) {
						System.out.println(t.getTid()+"  "+t.getTname());
					}
					SysOutAccess.asterisk();
					SysOutAccess.continueIn();
					SysOutAccess.queryTeam();
					break;
				}
				case "3" :{
					flag=false;
					SysOutAccess.menuQuery();
					break;
				}
				case "4" :end();break;
			}
		}
	}
	
	public static void findCharactar(){
		Vector<CharactarDTO> v=new Vector<CharactarDTO>();
		SysOutAccess.queryCharactar();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1" :{
					System.out.println("请输入要查找的sid：");
					String sid=scanf.nextLine();
					System.out.println("请输入要查找的tid：");
					String tid=scanf.nextLine();
					if(ch.findCharactarBySidATid(sid, tid)) {
						SysOutAccess.asterisk();
						SysOutAccess.charactarTopName();
						v=ch.findCharactarBySidATidOut(sid, tid);
						for(CharactarDTO c:v) {
							System.out.println(c.getSid()+"  "+c.getTid()+"  "+c.getRole());
						}
							
						SysOutAccess.asterisk();
						SysOutAccess.continueIn();
						SysOutAccess.queryCharactar();
					}
					else {
						SysOutAccess.queryNo();
						SysOutAccess.queryCharactar();
					}
					break;
				}
				case "2" :{
					v=ch.findAllCharactar();
					System.out.println("查询成功，结果如下！");
					SysOutAccess.asterisk();
					SysOutAccess.charactarTopName();
					for(CharactarDTO c:v) {
						System.out.println(c.getSid()+"  "+c.getTid()+"  "+c.getRole());
					}
					SysOutAccess.asterisk();
					SysOutAccess.continueIn();
					SysOutAccess.queryCharactar();
					break;
				}
				case "3" :{
					flag=false;
					SysOutAccess.menuQuery();
					break;
				}
				case "4" :end();break;
			}
		}
	}
	
	public static void end() {
		System.out.println("感谢使用，系统已退出！！！");
		System.exit(0);
	}
}
