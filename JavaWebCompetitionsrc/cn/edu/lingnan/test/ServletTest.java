package cn.edu.lingnan.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/servletTest")
public class ServletTest extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException,IOException {
		resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World 2020!</h1>");
        out.println("</body>");
        out.println("</html>");
	}

	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException {
			doGet(req,resp);
		}
}
