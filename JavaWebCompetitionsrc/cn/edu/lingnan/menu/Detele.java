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

public class Detele {
	
	public static Scanner scanf=new Scanner(System.in);
	public static StudentDAO sd=new StudentDAO();
	public static StudentDTO s=new StudentDTO();
	public static TeamDAO te=new TeamDAO();
	public static TeamDTO t=new TeamDTO();
	public static CharactarDAO ch=new CharactarDAO();
	public static CharactarDTO c=new CharactarDTO();
	
	public static void deteleStu() {
		Vector<StudentDTO> v=new Vector<StudentDTO>();
		SysOutAccess.deleteStu();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1" :{
					System.out.println("������Ҫɾ����sid��");
					String sid=scanf.nextLine();
					if(sd.findStuBySid(sid)) {
						sd.deleteStuBySid(sid);
						System.out.println("ɾ���ɹ���");
						SysOutAccess.continueIn();
						SysOutAccess.deleteStu();
					}
					else {
						System.out.println("��sid�����ڣ�");
						System.out.println("ɾ��ʧ�ܣ�");
						SysOutAccess.continueIn();
						SysOutAccess.deleteStu();
					}
					break;
				}
				case "2" :{
					v=sd.findDeletedStu();
					SysOutAccess.asterisk();
					SysOutAccess.stuTopName();
					for(StudentDTO s:v) {
						System.out.println(s.getSid()+"  "+s.getSname()+"  "+s.getPassword()+"  "+s.getSuperuser());
					}
					SysOutAccess.asterisk();
					SysOutAccess.continueIn();
					SysOutAccess.deleteStu();
					break;
				}
				case "3" :{
					flag=false;
					SysOutAccess.menuDetele();
					break;
				}
				case "4" :{
					end();
					break;
				}
			}
		}
	}
	
	public static void deteleTeam() {
		Vector<TeamDTO> v=new Vector<TeamDTO>();
		SysOutAccess.deleteTeam();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1" :{
					System.out.println("������Ҫɾ����tid��");
					String tid=scanf.nextLine();
					if(te.findTeamByTid(tid)) {
						te.deleteTeamByTid(tid);
						System.out.println("ɾ���ɹ���");
						SysOutAccess.continueIn();
						SysOutAccess.deleteStu();
					}
					else {
						System.out.println("��tid�����ڣ�");
						System.out.println("ɾ��ʧ�ܣ�");
						SysOutAccess.continueIn();
						SysOutAccess.deleteStu();
					}
					break;
				}
				case "2" :{
					v=te.findDeteledTeam();
					SysOutAccess.asterisk();
					SysOutAccess.teamTopName();
					for(TeamDTO t:v) {
						System.out.println(t.getTid()+"  "+t.getTname());
					}
					SysOutAccess.asterisk();
					SysOutAccess.continueIn();
					SysOutAccess.deleteStu();
					break;
				}
				case "3" :{
					flag=false;
					SysOutAccess.menuDetele();
					break;
				}
				case "4" :{
					end();
					break;
				}
			}
		}
	}

	public static void deteleCharactar() {
		Vector<CharactarDTO> v=new Vector<CharactarDTO>();
		SysOutAccess.deleteCharactar();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1" :{
					System.out.println("������Ҫɾ����sid��");
					String sid=scanf.nextLine();
					System.out.println("������Ҫɾ����tid��");
					String tid=scanf.nextLine();
					if(ch.findCharactarBySidATid(sid, tid)) {
						ch.findDeteledCharactar();
						System.out.println("ɾ���ɹ���");
						SysOutAccess.continueIn();
						SysOutAccess.deleteStu();
					}
					else {
						System.out.println("��sid��tid�����ڣ�");
						System.out.println("ɾ��ʧ�ܣ�");
						SysOutAccess.continueIn();
						SysOutAccess.deleteStu();
					}
					break;
				}
				case "2" :{
					v=ch.findDeteledCharactar();
					SysOutAccess.asterisk();
					SysOutAccess.charactarTopName();
					for(CharactarDTO c:v) {
						System.out.println(c.getSid()+"  "+c.getTid()+"  "+c.getRole());
					}
					SysOutAccess.asterisk();
					SysOutAccess.continueIn();
					SysOutAccess.deleteStu();
					break;
				}
				case "3" :{
					flag=false;
					SysOutAccess.menuDetele();
					break;
				}
				case "4" :{
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
