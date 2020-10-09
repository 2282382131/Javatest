package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.CharactarDAO;
@WebServlet("/admin/permanentDeteleCharactar")
public class PermanentCharactarServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		String sid=req.getParameter("sid");
		String tid=req.getParameter("tid");
		CharactarDAO cd=new CharactarDAO();
		cd.permanentdeleteCharactarBySidAndTid(sid, tid);
		resp.sendRedirect(req.getContextPath()+"/admin/findAllDeteledCharactar");
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		doGet(req,resp);
	}
}
