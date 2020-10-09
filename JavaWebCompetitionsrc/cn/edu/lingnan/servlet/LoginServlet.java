package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.StudentDAO;
import cn.edu.lingnan.dto.StudentDTO;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		System.out.println(username+"  "+password);
		StudentDAO s=new StudentDAO();
		StudentDTO st=new StudentDTO();
		st=s.newlogin(username, password);
		String sid=st.getSid();
		int superuser=st.getSuperuser();
		HttpSession hs=req.getSession();
		hs.setAttribute("superuser", superuser);
		hs.setAttribute("findStu", st);
		hs.setAttribute("sid", sid);
//		boolean flag=s.login(username, password);
		
//		if(flag) {
//			resp.sendRedirect(req.getContextPath()+"/homepage.html");
//		}
		if(superuser!=0) {
			resp.sendRedirect(req.getContextPath()+"/homepage.html");
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		doGet(req,resp);
	}
}
