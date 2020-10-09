package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.StudentDAO;
import cn.edu.lingnan.dto.StudentDTO;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		String sid=req.getParameter("sid");
		String sname=req.getParameter("sname");
		String password=req.getParameter("password");
		StudentDAO sd=new StudentDAO();
		StudentDTO s=new StudentDTO();
		s.setSid(sid);
		s.setSname(sname);
		s.setPassword(password);
		s.setSuperuser(3);
		if(!sd.findStuBySid(sid)) {
			sd.insertStu(s);
			resp.sendRedirect(req.getContextPath()+"/index.html");
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
