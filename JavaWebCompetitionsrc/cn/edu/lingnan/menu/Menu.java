package cn.edu.lingnan.menu;

import java.util.Scanner;

import cn.edu.lingnan.util.SysOutAccess;

public class Menu {
	
	public static Scanner scanf=new Scanner(System.in);
	
	public static void query() {
		System.out.println("--------查询信息--------");
//		System.out.println("--1、查询student信息；2、查询team信息；3、查询charactar信息；4、返回上一级；5、退出系统--");
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
//					System.out.println("--1、查询信息；2、增加信息；3、修改信息；4、删除信息；5、退出系统--");
					SysOutAccess.menuOne();
					break;
				}
				case "5" :end();break;
			}
		}
		
	}
	
	public static void add() {
		System.out.println("--------增加信息--------");	
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
		System.out.println("--------修改信息--------");
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
		System.out.println("--------删除信息--------");
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
		System.out.println("感谢使用，系统已退出！！！");
		System.exit(0);
	}
	
	
	
	
}
