package cbc.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbc.model.User;
import cbc.utils.UserUtils;

public class FindAllUserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FindAllUserServlet() {
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
		UserUtils userUtils = new UserUtils();
		List<User> users = new ArrayList<User>();
		users = userUtils.findAll();
		
		 PrintWriter out = response.getWriter();
		
		    for (User user : users) {
				out.print("用户id为:");
				out.println(user.getId());
				out.print("用户名为:");
				out.println(user.getUsername());
				out.print("用户密码为:");
				out.println(user.getPassword());
				out.print("用户邮箱为:");
				out.println(user.getEmail());
				out.print("用户创建时间为为:");
				out.println(user.getUpdate_date());
				out.println("</br>");
			}
	        response.setContentType("text/html");
	        out.println("<html>");
			out.println("<head>");
			out.println("<title>查询所有用户信息</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("</br>");
			out.println("<a href='/dorm/usercontrol.jsp'>返回</a>");
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