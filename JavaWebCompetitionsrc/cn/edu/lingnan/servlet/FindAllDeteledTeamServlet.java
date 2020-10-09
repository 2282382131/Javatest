package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TeamDAO;
import cn.edu.lingnan.dto.TeamDTO;
@WebServlet("/admin/findAllDeteledTeam")
public class FindAllDeteledTeamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		TeamDAO td=new TeamDAO(); 
		Vector<TeamDTO> v=td.findDeteledTeam();
		HttpSession s=req.getSession();
		s.setAttribute("allDeteledTeam", v);
		resp.sendRedirect(req.getContextPath()+"/admin/allDeteledTeam.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		doGet(req,resp);
	}
}
