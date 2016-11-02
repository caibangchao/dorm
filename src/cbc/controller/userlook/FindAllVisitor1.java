package cbc.controller.userlook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbc.model.Visitor;
import cbc.utils.VisitorUtils;

public class FindAllVisitor1 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FindAllVisitor1() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("GB2312");
		VisitorUtils visitorUtils = new VisitorUtils();
		List<Visitor> visitors = new ArrayList<Visitor>();
		visitors = visitorUtils.findAll();
		
		 PrintWriter out = response.getWriter();
		
		    for (Visitor visitor:visitors) {
		    	
		    	out.print("访问人次为:");
				out.println(visitor.getId());
				out.print("访问人名字为:");
				out.println(visitor.getName());
				out.print("访问人地址为:");
				out.println(visitor.getAddress());
				out.print("与受访学生关系为:");
				out.println(visitor.getRelation());
				out.print("受访问学生名字为:");
				out.println(visitor.getStudent_name());
				out.print("访问宿舍ID为:");
				out.println(visitor.getDorm_id());
				
				out.print("来访时间为:");
				out.println(visitor.getUpdate_date());
				
				
				out.println("</br>");
				
			}
	        response.setContentType("text/html");
	        out.println("<html>");
			out.println("<head>");
			out.println("<title>查询所有访客信息</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("</br>");
			out.println("<a href='/dorm/userlook.jsp'>返回</a>");
			out.println("</body>");
			out.println("</html>");
	    out.flush();
	    out.close();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
