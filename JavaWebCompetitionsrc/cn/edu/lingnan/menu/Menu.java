package cn.edu.lingnan.menu;

import java.util.Scanner;

import cn.edu.lingnan.util.SysOutAccess;

public class Menu {
	
	public static Scanner scanf=new Scanner(System.in);
	
	public static void query() {
		System.out.println("--------��ѯ��Ϣ--------");
//		System.out.println("--1����ѯstudent��Ϣ��2����ѯteam��Ϣ��3����ѯcharactar��Ϣ��4��������һ����5���˳�ϵͳ--");
		SysOutAccess.menuQuery();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1" :Query.findStu();break;
				case "2" :Query.findTeam();break;
				case "3" :Query.findCharactar();break;
				case "4" :{
					flag=false;
//					System.out.println("--1����ѯ��Ϣ��2��������Ϣ��3���޸���Ϣ��4��ɾ����Ϣ��5���˳�ϵͳ--");
					SysOutAccess.menuOne();
					break;
				}
				case "5" :end();break;
			}
		}
		
	}
	
	public static void add() {
		System.out.println("--------������Ϣ--------");	
		SysOutAccess.menuAdd();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1" :Add.addStu();break;
				case "2" :Add.addTeam();break;
				case "3" :Add.addCharactar();break;
				case "4" :{
					flag=false;
					SysOutAccess.menuOne();
					break;
				}
				case "5" :end();break;
			}
		}
	}
	
	public static void modify() {
		System.out.println("--------�޸���Ϣ--------");
		SysOutAccess.menuModify();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1" :Modify.modifyStu();break;
				case "2" :Modify.modifyTeam();break;
				case "3" :Modify.modifyCharactar();break;
				case "4" :{
					flag=false;
					SysOutAccess.menuOne();
					break;
				}
				case "5" :end();break;
				
			}
		}
	}
	
	public static void delete() {
		System.out.println("--------ɾ����Ϣ--------");
		SysOutAccess.menuDetele();
		boolean flag=true;
		while(flag) {
			String str=scanf.nextLine();
			switch(str) {
				case "1":Detele.deteleStu();break;
				case "2":Detele.deteleTeam();break;
				case "3":Detele.deteleCharactar();break;
				case "4":{
					flag=false;
					SysOutAccess.menuOne();
					break;
				}
				case "5":end();break;
			}
		}
		
	}
	
	public static void end() {
		System.out.println("��лʹ�ã�ϵͳ���˳�������");
		System.exit(0);
	}
	
	
	
	
}
