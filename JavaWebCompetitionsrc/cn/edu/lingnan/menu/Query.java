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
//		System.out.println("--1����ѯ��sname��password��2����ѯ��sid��3����ѯ����student��4��������һ����5���˳�ϵͳ--");
		SysOutAccess.queryStu();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1" :{
					System.out.println("������Ҫ���ҵ�sname��");
					String sname=scanf.nextLine();
					System.out.println("������Ҫ���ҵ�password��");
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
					System.out.println("������Ҫ���ҵ�sid�ţ�");
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
					System.out.println("��ѯ�ɹ���������£�");
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
//					System.out.println("--1����ѯstudent��Ϣ��2����ѯteam��Ϣ��3����ѯcharactar��Ϣ��4��������һ����5���˳�ϵͳ--");
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
					System.out.println("������Ҫ���ҵ�tid��");
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
					System.out.println("��ѯ�ɹ���������£�");
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
					System.out.println("������Ҫ���ҵ�sid��");
					String sid=scanf.nextLine();
					System.out.println("������Ҫ���ҵ�tid��");
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
					System.out.println("��ѯ�ɹ���������£�");
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
		System.out.println("��лʹ�ã�ϵͳ���˳�������");
		System.exit(0);
	}
}
