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
import cn.edu.lingnan.dao.StudentDAO;
import cn.edu.lingnan.dto.CharactarDTO;
import cn.edu.lingnan.dto.StudentDTO;
@WebServlet("/findStudent")
public class FindStudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		HttpSession hs=req.getSession();
		String sid=(String)hs.getAttribute("sid");
		StudentDAO sd=new StudentDAO(); 
		CharactarDAO cd=new CharactarDAO();
		StudentDTO sdto=sd.findStuduenBySidOut(sid);
		Vector<CharactarDTO> v=cd.findCharactarBySid(sid);
		HttpSession s=req.getSession();
		s.setAttribute("findstudent", sdto);
		s.setAttribute("findCharactarBySid", v);
		resp.sendRedirect(req.getContextPath()+"/findStudent.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		doGet(req,resp);
	}

}
