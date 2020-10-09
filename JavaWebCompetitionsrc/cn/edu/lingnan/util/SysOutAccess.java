package cn.edu.lingnan.util;

public class SysOutAccess {
	public static void asterisk() {
		System.out.println("*****************************************");
	}
	
	public static void stuTopName() {
		System.out.println("sid--sname--password--superuser");
	}
	
	public static void teamTopName() {
		System.out.println("tid---tname");
	}
	
	public static void charactarTopName() {
		System.out.println("sid--tid--role");
	}
	
	public static void continueIn() {
		System.out.println("亲！若不满意！！！请继续输入......");
	}
	public static void queryNo() {
		System.out.println("查找失败！请重新选择服务......");
	}
	
	public static void menuOne() {
		System.out.println("--1、查询信息；2、增加信息；3、修改信息；4、删除信息；5、退出系统--.");
	}
	
	public static void menuQuery() {
		System.out.println("--1、查询student信息；2、查询team信息；3、查询charactar信息；4、返回上一级；5、退出系统--");
	}
	
	public static void queryStu() {
		System.out.println("--1、查询按sname和password；2、查询按sid；3、查询所有student；4、返回上一级；5、退出系统--");
	}
	
	public static void queryTeam() {
		System.out.println("--1、查询按tid；2、查询所有team；3、返回上一级；4、退出系统--");
	}
	
	public static void queryCharactar() {
		System.out.println("--1、查询按sid和tid；2、查询所有charactar；3、返回上一级；4、退出系统--");
	}
	
	public static void menuAdd() {
		System.out.println("--1、增加student信息；2、增加team信息；3、增加charactar信息；4、返回上一级；5、退出系统--");
	}
	
	public static void addStu() {
		System.out.println("--1、插入student；2、返回上一级；3、退出系统--");
	}
	
	public static void addTeam() {
		System.out.println("--1、插入team；2、返回上一级；3、退出系统--");
	}
	
	public static void addCharactar() {
		System.out.println("--1、插入charactar；2、返回上一级；3、退出系统--");
	}
	
	public static void menuModify() {
		System.out.println("--1、修改student信息；2、修改team信息；3、修改charactar信息；4、返回上一级；5、退出系统--");
	}
	
	public static void modifyStu() {
		System.out.println("--1、更新student；2、返回上一级；3、退出系统--");
	}
	
	public static void modifyTeam() {
		System.out.println("--1、更新Team；2、返回上一级；3、退出系统--");
	}
	
	public static void modifyCharactar() {
		System.out.println("--1、更新Charactar；2、返回上一级；3、退出系统--");
	}
	
	public static void menuDetele() {
		System.out.println("--1、删除student信息；2、删除team信息；3、删除charactar信息；4、返回上一级；5、退出系统--");
	}
	
	public static void deleteStu() {
		System.out.println("--1、删除student；2、查询已删除student；3、返回上一级；4、退出系统--");
	}
	
	public static void deleteTeam() {
		System.out.println("--1、删除Team；2、查询已删除Team；3、返回上一级；4、退出系统--");
	}
	
	public static void deleteCharactar() {
		System.out.println("--1、删除Charactar；2、查询已删除Charactar；3、返回上一级；4、退出系统--");
	}
	
}
