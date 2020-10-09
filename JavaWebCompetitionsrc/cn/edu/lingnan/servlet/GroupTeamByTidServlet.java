package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.CharactarDAO;
import cn.edu.lingnan.dto.CharactarDTO;
@WebServlet("/admin/groupTeam")
public class GroupTeamByTidServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		CharactarDAO cd=new CharactarDAO(); 
		String tid=req.getParameter("tid");
		Vector<CharactarDTO> v=cd.findGroupCharactar(tid);
		int num=cd.findGroupCharactarNum(tid);
		HttpSession s=req.getSession();
		s.setAttribute("groupByTidCharactar", v);
		s.setAttribute("num", num);
		resp.sendRedirect(req.getContextPath()+"/admin/groupByTidCharactar.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		doGet(req,resp);
	}
}
