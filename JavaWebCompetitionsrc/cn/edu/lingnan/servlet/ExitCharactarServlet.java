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
@WebServlet("/admin/exitCharactar")
public class ExitCharactarServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		CharactarDAO cd=new CharactarDAO(); 
		Vector<CharactarDTO> v=cd.findexitCharactar();
		HttpSession s=req.getSession();
		s.setAttribute("exitCharactar", v);
		resp.sendRedirect(req.getContextPath()+"/admin/exitCharactar.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		doGet(req,resp);
	}
}
