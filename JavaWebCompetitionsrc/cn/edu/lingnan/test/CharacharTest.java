package cn.edu.lingnan.test;

import java.util.Vector;

import cn.edu.lingnan.dao.CharactarDAO;
import cn.edu.lingnan.dto.CharactarDTO;

public class CharacharTest {

	public static void main(String[] args) {
		CharactarDAO ch=new CharactarDAO();
		System.out.println(ch.findCharactarBySidATid("s01", "t01"));
		System.out.println(ch.findCharactarBySidATid("s01", "t12"));
		Vector<CharactarDTO> v=new Vector<CharactarDTO>();
//		v=ch.findAllCharactar();
//		for(CharactarDTO c:v)
//			System.out.println(c.getSid()+"  "+c.getTid()+"  "+c.getRole());
		
		v=ch.findDeteledCharactar();
		for(CharactarDTO c:v)
			System.out.println(c.getSid()+"  "+c.getTid()+"  "+c.getRole());
		
//		ch.deleteCharactarBySidAndTid("s01", "t02");
		CharactarDTO c=new CharactarDTO();
//		c.setSid("s02");
//		c.setTid("t02");
//		c.setRole("team leader");
//		if(ch.updataCharactar(c))
//			System.out.println("修改成功");
//		else
//			System.out.println("修改失败");
		
//		c.setSid("s04");
//		c.setTid("t04");
//		c.setRole("team leader");
//		if(ch.insertCharactar(c))
//			System.out.println("插入成功");
//		else
//			System.out.println("插入失败");
	}

}
