package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.CharactarDAO;
import cn.edu.lingnan.dto.CharactarDTO;
@WebServlet("/admin/updateApplyCharactar")
public class AgreeCharactarServlet extends HttpServlet {

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
		CharactarDTO c=new CharactarDTO();
		c.setSid(sid);
		c.setTid(tid);
		cd.updataApplyCharactar(c);
		resp.sendRedirect(req.getContextPath()+"/admin/findAllCharactar");
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		doGet(req,resp);
	}
}
