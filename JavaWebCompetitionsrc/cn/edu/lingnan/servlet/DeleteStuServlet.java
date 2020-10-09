package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.StudentDAO;
@WebServlet("/admin/deleteStu")
public class DeleteStuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		String del=req.getParameter("del");
		StudentDAO sd=new StudentDAO();
		
		if(del==null) {
			int suser=Integer.parseInt(req.getParameter("superuser"));
			HttpSession s=req.getSession();
			int loginid=(int)s.getAttribute("superuser");
			String sid=req.getParameter("sid");
			if(loginid==1) {
				sd.deleteStuBySid(sid);
				resp.sendRedirect(req.getContextPath()+"/admin/findAllStu");
			}
			else {
				if(suser==3) {
					sd.deleteStuBySid(sid);
					resp.sendRedirect(req.getContextPath()+"/admin/findAllStu");
				}
				else {
					resp.sendRedirect(req.getContextPath()+"/deteleerror.html");
				}
			}
		}
		
		else {
			String allsid=req.getParameter("allsid");
			System.out.println(allsid);
			String[] temp=allsid.split(",");
			for(String as:temp) {
				sd.deleteStuBySid(as);
			}
			resp.sendRedirect(req.getContextPath()+"/admin/findAllStu");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
		doGet(req,resp);
	}
}
