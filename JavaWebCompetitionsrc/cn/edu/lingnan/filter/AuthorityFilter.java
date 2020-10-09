package cn.edu.lingnan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter("/admin/*")
public class AuthorityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) arg0;
		HttpSession s=req.getSession();
		Integer i=(Integer)s.getAttribute("superuser");
		HttpServletResponse resp=(HttpServletResponse) arg1;
		if(i!=null) {
			if(i==1||i==2) {
				arg2.doFilter(arg0, arg1);
			}
			else {
				resp.sendRedirect(req.getContextPath()+"/authority.html");
			}
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/index.html");
		}
		
	}

}
