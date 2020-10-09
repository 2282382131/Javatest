package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.TeamDAO;
import cn.edu.lingnan.dto.TeamDTO;
@WebServlet("/admin/registerTeam")
public class AddTeamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		String tid=req.getParameter("tid");
		String tname=req.getParameter("tname");
		TeamDAO td=new TeamDAO();
		TeamDTO t=new TeamDTO();
		t.setTid(tid);
		t.setTname(tname);
		if(!td.findTeamByTid(tid)) {
			td.insertTeam(t);
			resp.sendRedirect(req.getContextPath()+"/addOk.html");
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/adderror.html");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		doGet(req,resp);
	}
}
