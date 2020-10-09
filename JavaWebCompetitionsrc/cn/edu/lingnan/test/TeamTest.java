package cn.edu.lingnan.test;

import java.util.Vector;

import cn.edu.lingnan.dao.TeamDAO;
import cn.edu.lingnan.dto.TeamDTO;

public class TeamTest {

	public static void main(String[] args) {
		TeamDAO te=new TeamDAO();
//		System.out.println(te.findTeamByTid("t01"));
//		System.out.println(te.findTeamByTid("t11"));
//		
		Vector<TeamDTO> v=new Vector<TeamDTO>();
//		v=te.findAllTeam();
//		for(TeamDTO t:v)
//			System.out.println(t.getTid()+"  "+t.getTname());
		
		v=te.findDeteledTeam();
		for(TeamDTO t:v)
			System.out.println(t.getTid()+"  "+t.getTname());
		
//		te.deleteTeamByTid("t01");
		
//		TeamDTO t=new TeamDTO();
//		t.setTid("t02");
//		t.setTname("team two");
//		if(te.updataTeam(t))
//			System.out.println("更新成功");
//		else
//			System.out.println("更新失败");
		
//		t.setTid("t05");
//		t.setTname("team five");
//		if(te.insertTeam(t))
//			System.out.println("插入成功");
//		else
//			System.out.println("插入失败");
		
	}

}
