package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.StudentDAO;
import cn.edu.lingnan.dto.StudentDTO;
@WebServlet("/admin/updateStu")
public class UpdateStuServlet extends HttpServlet {

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
		String superuser=req.getParameter("superuser");
		StudentDAO sd=new StudentDAO();
		StudentDTO s=new StudentDTO();
		s.setSid(sid);
		s.setSname(sname);
		s.setPassword(password);
		s.setSuperuser(Integer.parseInt(superuser));
		sd.updateStu(s);
		resp.sendRedirect(req.getContextPath()+"/admin/findAllStu");
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		doGet(req,resp);
	}
}
