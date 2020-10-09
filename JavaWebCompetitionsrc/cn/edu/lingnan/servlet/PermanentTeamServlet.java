package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.TeamDAO;
@WebServlet("/admin/permanentDeteledTeam")
public class PermanentTeamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		String tid=req.getParameter("tid");
		TeamDAO td=new TeamDAO();
		td.permanentdeleteTeamByTid(tid);
		resp.sendRedirect(req.getContextPath()+"/admin/findAllDeteledTeam");
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		doGet(req,resp);
	}
}
