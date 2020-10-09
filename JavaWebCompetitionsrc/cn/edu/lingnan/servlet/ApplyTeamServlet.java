package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.CharactarDAO;
import cn.edu.lingnan.dto.CharactarDTO;
@WebServlet("/applyTeam")
public class ApplyTeamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		String tid=req.getParameter("tid");
		HttpSession s=req.getSession();
		String sid=(String) s.getAttribute("sid");
		CharactarDAO cd=new CharactarDAO();
		CharactarDTO c=new CharactarDTO();
		c.setSid(sid);
		c.setTid(tid);
		c.setRole("team member");
		if(!cd.findCharactarBySidATid(sid, tid)) {
			cd.applyCharactar(c);
			resp.sendRedirect(req.getContextPath()+"/applyok.html");
		}
			
		else {
			resp.sendRedirect(req.getContextPath()+"/applyerror.html");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		doGet(req,resp);
	}
}
