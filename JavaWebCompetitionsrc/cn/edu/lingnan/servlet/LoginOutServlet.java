package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/loginOutServlet","/admin/loginOutServlet"})
public class LoginOutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		HttpSession s=req.getSession();
		s.invalidate();
		resp.sendRedirect(req.getContextPath()+"/index.html");
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		doGet(req,resp);
	}
}
