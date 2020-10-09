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
@WebServlet("/admin/findAllDeteledCharactar")
public class FindAllDeteledCharactarServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		CharactarDAO cd=new CharactarDAO(); 
		Vector<CharactarDTO> v=cd.findDeteledCharactar();
		HttpSession s=req.getSession();
		s.setAttribute("allDeteledCharactar", v);
		resp.sendRedirect(req.getContextPath()+"/admin/allDeteledCharactar.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		doGet(req,resp);
	}
}
