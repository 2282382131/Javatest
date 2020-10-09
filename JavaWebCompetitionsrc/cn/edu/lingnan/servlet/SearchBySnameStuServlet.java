package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.StudentDAO;
import cn.edu.lingnan.dto.StudentDTO;
@WebServlet("/admin/searchBySnameStu")
public class SearchBySnameStuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		StudentDAO sd=new StudentDAO();
		String searchsname=(String)req.getParameter("searchsname");
		Vector<StudentDTO> v=sd.searchStuBySidOut(searchsname);
		HttpSession s=req.getSession();
		s.setAttribute("searchStu", v);
		resp.sendRedirect(req.getContextPath()+"/admin/searchStu.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		doGet(req,resp);
	}
}
